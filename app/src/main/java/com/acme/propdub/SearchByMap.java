package com.acme.propdub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.gms.maps.MapView;

public class SearchByMap extends AppCompatActivity {

    MapView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_map);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.back_button);
            actionBar.setTitle("Search by Map");}
        try {
            mapView=findViewById(R.id.map_view);
            mapView.onCreate(savedInstanceState);
        }catch(Exception e){
            Log.d("tag9", e.toString());
        }
        Log.d("tag9", "correct ");
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    @Override
    public void onResume(){
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onDestroy(){
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onPause(){
        mapView.onPause();
        super.onPause();
    }

    @Override
    public void onLowMemory(){
        mapView.onLowMemory();
        super.onLowMemory();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the action bar's Up/Home button
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}