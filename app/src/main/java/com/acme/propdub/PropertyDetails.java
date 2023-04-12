package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PropertyDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_details);

        //the searchQuery is coming from the search bar.

        String searchQuery = getIntent().getStringExtra("search_query");
        // Use the searchQuery to fetch the data or perform any required operation
    }
}