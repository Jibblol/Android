package com.example.vegard.hotellapp.layout;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.vegard.hotellapp.HotellApp;
import com.example.vegard.hotellapp.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomServiceFragment extends Fragment implements View.OnClickListener {

    private HotellApp hotell;

    private int sum = 0;

    ArrayAdapter<String> listAdapter;
    ListView menuList;

    public RoomServiceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hotell = HotellApp.getInstance();

        List<Map.Entry<String, Integer>> menuItemsAsList = new LinkedList<>(hotell.getMenuItems().entrySet());

        List<String> menuItems = new ArrayList<>();
        for(Map.Entry<String, Integer> item : menuItemsAsList ){
            menuItems.add(item.getKey() + " - " + item.getValue());
        }

        listAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, menuItems);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_room, container, false);
        menuList = (ListView)view.findViewById(R.id.menuList);
        menuList.setAdapter(listAdapter);

        view.findViewById(R.id.orderBtn).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < menuList.getChildCount(); i++) {
            menuList.setItemChecked(i, false);
        }
    }
}
