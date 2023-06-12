package com.acme.propdub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.maps.MapView;

import java.util.ArrayList;
import java.util.List;

public class Support extends AppCompatActivity {
MapView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

try{
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back_button);
        actionBar.setTitle("Contact");
    }
}catch(Exception e){
    Log.d("tag9",e.toString());
}
        mapView = findViewById(R.id.map_view);
            mapView.onCreate(savedInstanceState);

        Spinner countrySpinner = findViewById(R.id.totalAmountEditText3);

// Create a list of countries
        List<String> countries = new ArrayList<>();
        countries.add("Country 1");
        countries.add("Country 2");
        countries.add("Country 3");
// Add more countries as needed

// Create an ArrayAdapter for the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_dropdown_item, countries);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);

// Set the adapter for the Spinner
        countrySpinner.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
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