package com.example.vegard.hotellapp.layout;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vegard.hotellapp.HotellApp;
import com.example.vegard.hotellapp.R;
import com.example.vegard.hotellapp.roomservice.RoomServiceMenuAdapter;
import com.example.vegard.hotellapp.roomservice.RoomServiceMenuItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomServiceFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private HotellApp hotell;

    private int sum = 0;

    RoomServiceMenuAdapter adapter;
    ListView menuList;
    TextView totalPrice;

    public RoomServiceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hotell = HotellApp.getInstance();

        adapter = new RoomServiceMenuAdapter(getContext(), hotell.getMenuItems());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_room, container, false);
        menuList = (ListView)view.findViewById(R.id.menuList);
        menuList.setAdapter(adapter);
        menuList.setChoiceMode(menuList.CHOICE_MODE_MULTIPLE);
        menuList.setOnItemClickListener(this);

        totalPrice = (TextView)view.findViewById(R.id.itemsPrice);
        updateTotal();

        view.findViewById(R.id.orderBtn).setOnClickListener(this);

        return view;
    }

    private void updateTotal() {
        totalPrice.setText(Integer.toString(sum) + " points");
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), "Submitting order..", Toast.LENGTH_LONG).show();
        int points = hotell.getBonusPoints();
        hotell.setBonusPoints(points - sum);

        for (int i = 0; i < menuList.getChildCount(); i++) {
            menuList.setItemChecked(i, false);
        }
        sum = 0;
        updateTotal();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (menuList.isItemChecked(position)) {
            sum += ((RoomServiceMenuItem)menuList.getItemAtPosition(position)).getPrice();
        } else {
            sum -= ((RoomServiceMenuItem)menuList.getItemAtPosition(position)).getPrice();
        }

        updateTotal();
    }
}
