package com.example.vegard.hotellapp;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.content.AsyncTaskLoader;

import com.example.vegard.hotellapp.Booking;
import com.example.vegard.hotellapp.BookingsManager;

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
import java.util.ArrayList;
import java.util.List;

// Kilde: http://www.concretepage.com/android/android-asynctaskloader-example-with-listview-and-baseadapter
class BookingLoader extends AsyncTaskLoader<List<Booking>> {
    private static final String bookingApi = "http://hotellapi.herokuapp.com/bookings";

    public BookingLoader(Context context) {
        super(context);
    }

    @Override
    public List<Booking> loadInBackground() {
        List<Booking> bookings = new ArrayList<>();

        HttpURLConnection conn = null;
        try {
            URL url = new URL(bookingApi);
            conn = (HttpURLConnection)url.openConnection();

            InputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            JSONArray bookingsJson = new JSONArray(responseStrBuilder.toString());

            for (int j = 0; j < bookingsJson.length(); j++) {
                JSONObject booking = bookingsJson.getJSONObject(j);
                JSONObject hotel = booking.getJSONObject("hotel");
                bookings.add(new Booking(hotel.getString("name"), booking.getString("room")));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }

        return bookings;
    }
}