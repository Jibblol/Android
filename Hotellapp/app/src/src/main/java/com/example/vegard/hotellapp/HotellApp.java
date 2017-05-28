package com.example.vegard.hotellapp;

import com.example.vegard.hotellapp.roomservice.RoomServiceMenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vegard on 25.05.2017.
 */

public class HotellApp {

    private static HotellApp hotell;
    private User user;
    private List<RoomServiceMenuItem> menuItems;

    public HotellApp(){
        menuItems = new ArrayList<>();
        menuItems.add(new RoomServiceMenuItem("Burger", 180));
        menuItems.add(new RoomServiceMenuItem("Pizza", 200));
        menuItems.add(new RoomServiceMenuItem("Turkey BLT", 150));
        menuItems.add(new RoomServiceMenuItem("Soda", 50));
        menuItems.add(new RoomServiceMenuItem("Beer", 100));
    }

    public List<RoomServiceMenuItem> getMenuItems(){
        return menuItems;
    }

    public static HotellApp getInstance(){
        if(hotell == null) hotell = new HotellApp();
        return hotell;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


