package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.MapView;

public class Support extends AppCompatActivity {
MapView mapView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        mapView = findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
    }
}