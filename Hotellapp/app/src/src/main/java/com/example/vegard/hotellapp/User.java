package com.example.vegard.hotellapp;

/**
 * Created by equivocal on 28.05.17.
 */

public class User {
    String username;
    String password;
    int bonuspoints;

    public User(String username, String password, int bonuspoints) {
        this.username = username;
        this.password = password;
        this.bonuspoints = bonuspoints;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getBonuspoints() {
        return bonuspoints;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBonuspoints(int bonuspoints) {
        this.bonuspoints = bonuspoints;
    }
}
