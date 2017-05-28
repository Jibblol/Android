package com.example.vegard.hotellapp.layout;


import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.vegard.hotellapp.booking.Booking;
import com.example.vegard.hotellapp.booking.BookingListAdapter;
import com.example.vegard.hotellapp.booking.BookingLoader;
import com.example.vegard.hotellapp.R;

import java.util.ArrayList;
import java.util.List;

public class BookingsFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Booking>> {

    BookingListAdapter bookingAdapter;

    @Override
    public Loader<List<Booking>> onCreateLoader(int id, Bundle args) {
        return new BookingLoader(getContext());
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bookings, container, false);
        bookingAdapter = new BookingListAdapter(getContext(), new ArrayList<Booking>());
        ListView bookingList = (ListView)view.findViewById(R.id.listView);

        bookingList.setAdapter(bookingAdapter);
        getLoaderManager().initLoader(1, null, this).forceLoad();

        return view;
    }
}
