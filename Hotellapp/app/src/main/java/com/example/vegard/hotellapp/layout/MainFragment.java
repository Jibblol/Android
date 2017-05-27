package com.example.vegard.hotellapp.layout;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.vegard.hotellapp.activities.BookingsActivity;
import com.example.vegard.hotellapp.activities.LateArrivalActivity;
import com.example.vegard.hotellapp.activities.MapActivity;
import com.example.vegard.hotellapp.R;
import com.example.vegard.hotellapp.activities.RoomServiceActivity;

public class MainFragment extends Fragment implements View.OnClickListener {

    private Button roomServiceBtn, lateArrivalBtn, mapBtn, myBookingsBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        roomServiceBtn = (Button)view.findViewById(R.id.roomServiceBtn);
        roomServiceBtn.setOnClickListener(this);

        lateArrivalBtn = (Button)view.findViewById(R.id.lateArrivalBtn);
        lateArrivalBtn.setOnClickListener(this);

        mapBtn = (Button)view.findViewById(R.id.mapBtn);
        mapBtn.setOnClickListener(this);

        myBookingsBtn = (Button)view.findViewById(R.id.myBookingsBtn);
        myBookingsBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == roomServiceBtn) {
            startActivity(new Intent(getContext(), RoomServiceActivity.class));
        } else if (v == lateArrivalBtn){
            startActivity(new Intent(getContext(), LateArrivalActivity.class));
        } else if (v == mapBtn){
            startActivity(new Intent(getContext(), MapActivity.class));
        } else if (v == myBookingsBtn){
            startActivity(new Intent(getContext(), BookingsActivity.class));
        }
    }
}
