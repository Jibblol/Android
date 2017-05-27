package com.example.vegard.hotellapp;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BookingsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Booking>> {
    BookingListAdapter bookingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        bookingAdapter = new BookingListAdapter(BookingsActivity.this, new ArrayList<Booking>());
        ListView bookingList = (ListView)findViewById(R.id.listView);

        bookingList.setAdapter(bookingAdapter);
        getSupportLoaderManager().initLoader(1, null, this).forceLoad();

    }

    @Override
    public Loader<List<Booking>> onCreateLoader(int id, Bundle args) {
        return new BookingLoader(BookingsActivity.this);
    }

    @Override
    public void onLoadFinished(Loader<List<Booking>> loader, List<Booking> bookings) {
        bookingAdapter.setBookings(bookings);
        bookingAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<List<Booking>> loader) {
        bookingAdapter.setBookings(new ArrayList<Booking>());
    }


}
