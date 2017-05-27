package com.example.vegard.hotellapp.activities;

import android.app.Fragment;

import com.example.vegard.hotellapp.layout.MainFragment;

public class MainActivity extends FragmentHolderActivity {
    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }
}
