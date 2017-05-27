package com.example.vegard.hotellapp.booking;

/**
 * Created by kongl on 27/05/2017.
 */

public class Booking {
    private String hotelName;
    private String roomType;

    public Booking(String hotelName, String roomType) {
        this.hotelName = hotelName;
        this.roomType = roomType;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getRoomType() {
        return roomType;
    }
}
