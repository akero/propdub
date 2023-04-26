package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//TODO: add filter, remove selectPropertyButton
public class SearchResults extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        // Initialize the map fragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        String searchQuery = getIntent().getStringExtra("search_query");
        // Use the searchQuery to fetch the data or perform any required operation

        View selectPropertyButton = findViewById(R.id.select_property_button);
        selectPropertyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPropertyDetailsActivity();
            }
        });
    //the searchQuery is coming from the search bar.


    // Use the searchQuery to fetch the data or perform any required operation


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10));
    }


    //TODO: remove this its placeholder till design is done
    // Method to navigate to PropertyRent
    private void openPropertyDetailsActivity() {
        Intent intent = new Intent(SearchResults.this, PropertyDetails.class);
        startActivity(intent);
    }
}
