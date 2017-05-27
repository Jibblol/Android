package com.example.vegard.hotellapp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vegard on 25.05.2017.
 */

public class HotellApp {

    private static HotellApp hotell;
    private String username;
    private String password;
    private Map<String, Integer> menuItems;

    public HotellApp(){
        menuItems = new HashMap<>();
    }

    public Map<String, Integer> getMenuItems(){
        menuItems.put("Burger", 200);
        menuItems.put("Pizzer", 150);
        menuItems.put("Rump", 100);
        menuItems.put("Stick of death", 1);
        menuItems.put("Die", 200);
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

}


