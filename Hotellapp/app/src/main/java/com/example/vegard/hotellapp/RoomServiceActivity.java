package com.example.vegard.hotellapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RoomServiceActivity extends AppCompatActivity {

    private HotellApp hotell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_service);
        hotell = HotellApp.getInstance();

        List<Map.Entry<String, Integer>> menuItemsAsList = new LinkedList<>(hotell.getMenuItems().entrySet());

        List<String> menuItems = new ArrayList<>();
        for(Map.Entry<String, Integer> item : menuItemsAsList ){
            menuItems.add(item.getKey() + " - " + item.getValue());
        }
        ArrayAdapter<String> listAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, menuItems);

        ((ListView)findViewById(R.id.menuList)).setAdapter(listAdapter);
    }
}
