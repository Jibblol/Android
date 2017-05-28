package com.example.vegard.hotellapp.booking;

import java.util.Date;

/**
 * Created by kongl on 27/05/2017.
 */

public class Booking {
    private String hotelName;
    private String roomType;
    private Date checkInDate;
    private Date checkOutDate;

    public Booking(String hotelName, String roomType, Date checkInDate, Date checkOutDate) {
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }
}
