package com.example.vegard.hotellapp.activities;

import android.app.Fragment;

import layout.RoomServiceFragment;

public class RoomServiceActivity extends FragmentHolderActivity {

    @Override
    protected Fragment createFragment() {
        return new RoomServiceFragment();
    }
}
