package com.example.vegard.hotellapp.booking;

import java.util.ArrayList;
import java.util.Date;

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

    public void addBooking(String hotelName, String roomType, Date checkIn, Date checkOut) {
        bookingList.add(new Booking(hotelName, roomType, checkIn, checkOut));
    }

    public ArrayList<Booking> getBookings() {
        return bookingList;
    }
}