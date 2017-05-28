package com.example.vegard.hotellapp.activities;

import android.app.Fragment;

import com.example.vegard.hotellapp.layout.RoomServiceFragment;

public class RoomServiceActivity extends FragmentHolderActivity {

    @Override
    protected Fragment createFragment() {
        return new RoomServiceFragment();
    }
}
