package com.example.vegard.hotellapp.roomservice;

/**
 * Created by Vegard on 28.05.2017.
 */

public class RoomServiceMenuItem {
    private String name;
    private int price;

    public RoomServiceMenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
