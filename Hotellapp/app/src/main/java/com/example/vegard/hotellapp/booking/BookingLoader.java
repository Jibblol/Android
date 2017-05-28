package com.example.vegard.hotellapp.booking;

import android.content.AsyncTaskLoader;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Kilde: http://www.concretepage.com/android/android-asynctaskloader-example-with-listview-and-baseadapter
// laster bookings fra et liksom-API i Heroku (laget med json-server)
public class BookingLoader extends AsyncTaskLoader<List<Booking>> {
    private static final String bookingApi = "http://hotellapi.herokuapp.com/bookings";

    public BookingLoader(Context context) {
        super(context);
    }

    @Override
    public List<Booking> loadInBackground() {
        List<Booking> bookings = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        HttpURLConnection conn = null;
        try {
            // åpne ekstern http-forbindelse til API
            URL url = new URL(bookingApi);
            conn = (HttpURLConnection)url.openConnection();

            // les respons til string
            InputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            // parse JSON og opprett Booking-POJOs
            JSONArray bookingsJson = new JSONArray(responseStrBuilder.toString());

            for (int j = 0; j < bookingsJson.length(); j++) {
                JSONObject booking = bookingsJson.getJSONObject(j);
                JSONObject hotel = booking.getJSONObject("hotel");

                Date checkIn = dateFormat.parse(booking.getString("startDate"));
                Date checkOut = dateFormat.parse(booking.getString("endDate"));

                Booking bookingObject = new Booking(hotel.getString("name"), booking.getString("room"), checkIn, checkOut );
                bookings.add(bookingObject);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            // lukk forbindelse uavhengig av eventuelle feil
            conn.disconnect();
        }

        return bookings;
    }
}