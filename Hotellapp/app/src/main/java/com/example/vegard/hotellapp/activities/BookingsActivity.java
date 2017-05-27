package com.example.vegard.hotellapp.activities;

import android.app.Fragment;

import com.example.vegard.hotellapp.layout.BookingsFragment;

public class BookingsActivity extends FragmentHolderActivity {
    @Override
    protected Fragment createFragment() {
        return new BookingsFragment();
    }
}
