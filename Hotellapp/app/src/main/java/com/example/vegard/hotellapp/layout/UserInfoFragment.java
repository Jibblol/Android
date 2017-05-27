package com.example.vegard.hotellapp.layout;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vegard.hotellapp.HotellApp;
import com.example.vegard.hotellapp.R;

public class UserInfoFragment extends Fragment {

    private HotellApp hotell;

    public UserInfoFragment() {
        hotell = HotellApp.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_info, container, false);
        ((TextView)view.findViewById(R.id.firstname)).setText(hotell.getUsername());
        return view;
    }

}
