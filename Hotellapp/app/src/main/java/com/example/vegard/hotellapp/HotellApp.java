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
    private String username;
    private String password;
    private List<RoomServiceMenuItem> menuItems;
    private int bonusPoints = 2000;

    public HotellApp(){
        menuItems = new ArrayList<>();
    }

    public List<RoomServiceMenuItem> getMenuItems(){
        menuItems.add(new RoomServiceMenuItem("Burger", 200));
        menuItems.add(new RoomServiceMenuItem("Pizzer", 150));
        menuItems.add(new RoomServiceMenuItem("Rump", 100));
        menuItems.add(new RoomServiceMenuItem("Stick of death", 1));
        menuItems.add(new RoomServiceMenuItem("Die", 200));
        return menuItems;
    }

    public static HotellApp getInstance(){
        if(hotell == null) hotell = new HotellApp();
        return hotell;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }
}


