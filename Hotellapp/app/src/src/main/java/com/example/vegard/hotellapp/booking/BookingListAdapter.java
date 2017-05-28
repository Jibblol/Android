package com.example.vegard.hotellapp.booking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vegard.hotellapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
            view = inflater.inflate(R.layout.booking_listitem, null);
        }

        TextView hotelName = (TextView) view.findViewById(R.id.hotelName);
        TextView roomType = (TextView) view.findViewById(R.id.roomType);
        TextView nights = (TextView) view.findViewById(R.id.nights);

        hotelName.setText(bookings.get(position).getHotelName());
        roomType.setText("Room type: " + bookings.get(position).getRoomType());

        long stayLength = bookings.get(position).getCheckOutDate().getTime() - bookings.get(position).getCheckInDate().getTime();

        nights.setText(TimeUnit.DAYS.convert(stayLength, TimeUnit.MILLISECONDS) + " nights");

        return view;
    }
}
