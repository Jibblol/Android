package com.example.vegard.hotellapp.booking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookingListAdapter extends BaseAdapter {
    private Context context;
    private List<Booking> bookings = new ArrayList<>();

    public BookingListAdapter(@NonNull Context context, @NonNull List<Booking> bookings) {
        this.context = context;
        this.bookings = bookings;
    }

    @Override
    public int getCount() {
        return bookings.size();
    }

    @Override
    public Object getItem(int position) {
        return bookings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        if (view == null) {
            view = inflater.inflate(android.R.layout.simple_list_item_2, null);
        }

        TextView hotelName = (TextView) view.findViewById(android.R.id.text1);
        TextView roomType = (TextView) view.findViewById(android.R.id.text2);
        hotelName.setText(bookings.get(position).getHotelName());
        roomType.setText("Room type: " + bookings.get(position).getRoomType());

        return view;
    }
}
