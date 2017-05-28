package com.example.vegard.hotellapp.layout;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.icu.util.Calendar;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vegard.hotellapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LateArrivalFragment extends Fragment implements View.OnClickListener{
    EditText date;
    DatePickerDialog datePickerDialog;

    public LateArrivalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_late_arrival, container, false);

        view.findViewById(R.id.notifyBtn).setOnClickListener(this);

        date = (EditText)view.findViewById(R.id.date);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date.setText(dayOfMonth + "/" + (monthOfYear +1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), "Front desk notified. Thank you!", Toast.LENGTH_LONG).show();
    }
}
