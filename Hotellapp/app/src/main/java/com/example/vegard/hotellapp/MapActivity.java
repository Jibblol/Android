package com.example.vegard.hotellapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng oslo = new LatLng(59.911191, 10.752537);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(oslo));

        googleMap.addMarker(new MarkerOptions().position(oslo)
                .title("Marker in Oslo"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(oslo, 15.0f));


//        Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode("Clarion hotell"));
//        Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
//        mapIntent.setPackage("com.google.android.apps.maps");
//        startActivity(mapIntent);
//        finish();
    }
}
