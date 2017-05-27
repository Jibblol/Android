package com.example.vegard.hotellapp;

import android.os.AsyncTask;

import java.net.URI;
import java.util.ArrayList;

public class BookingsManager {
    private static BookingsManager managerInstance;
    private ArrayList<Booking> bookingList;

    public static BookingsManager getInstance() {
        if (managerInstance == null) managerInstance = new BookingsManager();
        return managerInstance;
    }

    public BookingsManager() {
        bookingList = new ArrayList<>();
    }

    public void addBooking(String hotelName, String roomType) {
        bookingList.add(new Booking(hotelName, roomType));
    }

    public ArrayList<Booking> getBookings() {
        return bookingList;
    }
}