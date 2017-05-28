package com.example.vegard.hotellapp.roomservice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vegard.hotellapp.R;

import java.util.List;

/**
 * Created by Vegard on 28.05.2017.
 */

public class RoomServiceMenuAdapter extends BaseAdapter {
    private List<RoomServiceMenuItem> menuItems;
    private Context context;

    public RoomServiceMenuAdapter(@NonNull Context context, List<RoomServiceMenuItem> menuItems) {
        this.menuItems = menuItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public Object getItem(int position) {
        return menuItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        if (view == null) {
            view = inflater.inflate(android.R.layout.simple_list_item_multiple_choice, null);
        }

        TextView text = (TextView) view.findViewById(android.R.id.text1);

        text.setText(menuItems.get(position).getName() + " - " + menuItems.get(position).getPrice() + " points");

        return view;
    }
}
