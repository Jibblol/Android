package com.example.vegard.hotellapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Joakim Söderstrand on 27.02.17.
 * Abstract class to be extended by activities who implements menus/list.
 */

public abstract class FragmentHolderActivity extends AppCompatActivity {
    /**
     * Create the fragment to be loaded
     *
     * @return Fragment
     */
    protected abstract Fragment createFragment();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_holder_container);


        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_holder_container, fragment)
                    .commit();
        }
    }
}