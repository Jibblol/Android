package com.example.vegard.hotellapp;

import android.os.AsyncTask;

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

public class GetBookingsTask extends AsyncTask<URL, Integer, Integer> {
    private BookingsManager manager = BookingsManager.getInstance();

    @Override
    protected Integer doInBackground(URL... urls) {
        int count = urls.length;

        for (int i = 0; i < count; i++) {
            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection)urls[i].openConnection();

                InputStream in = new BufferedInputStream(conn.getInputStream());
                BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                StringBuilder responseStrBuilder = new StringBuilder();

                String inputStr;
                while ((inputStr = streamReader.readLine()) != null)
                    responseStrBuilder.append(inputStr);
                JSONArray bookings = new JSONArray(responseStrBuilder.toString());

                for (int j = 0; j < bookings.length(); j++) {
                    JSONObject booking = bookings.getJSONObject(j);
                    JSONObject hotel = booking.getJSONObject("hotel");
                    manager.addBooking(hotel.getString("name"), booking.getString("room"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                conn.disconnect();
            }
        }
        return 1;
    }
}
