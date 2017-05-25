package com.example.vegard.hotellapp;

/**
 * Created by Vegard on 25.05.2017.
 */

public class HotellApp {

    private static HotellApp hotell;
    private String username;
    private String password;

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


