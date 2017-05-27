package com.example.vegard.hotellapp.activities;

import android.app.Fragment;

import com.example.vegard.hotellapp.layout.LateArrivalFragment;

public class LateArrivalActivity extends FragmentHolderActivity {
    @Override
    protected Fragment createFragment() {
        return new LateArrivalFragment();
    }
}
