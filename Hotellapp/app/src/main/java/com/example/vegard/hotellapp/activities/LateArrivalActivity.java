package com.example.vegard.hotellapp.activities;

import android.app.Fragment;

import layout.LateArrivalFragment;

public class LateArrivalActivity extends FragmentHolderActivity {
    @Override
    protected Fragment createFragment() {
        return new LateArrivalFragment();
    }
}
