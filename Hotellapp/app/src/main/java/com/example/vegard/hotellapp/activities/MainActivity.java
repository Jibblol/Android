package com.example.vegard.hotellapp.activities;

import android.app.Fragment;

import layout.MainFragment;

public class MainActivity extends FragmentHolderActivity {
    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }
}
