package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//TODO: add filter, remove selectPropertyButton
public class SearchResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

    //the searchQuery is coming from the search bar.
        String searchQuery = getIntent().getStringExtra("search_query");

    // Use the searchQuery to fetch the data or perform any required operation

//TODO: remove this its placeholder till design is done
    //adding button temporarily for app skeleton which links to property details activity

        View selectPropertyButton = findViewById(R.id.select_property_button);
        // Set up click listeners for UI elements
        selectPropertyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPropertyDetailsActivity();
            }
        });
    }
    
//TODO: remove this its placeholder till design is done
    // Method to navigate to PropertyRent
    private void openPropertyDetailsActivity() {
        Intent intent = new Intent(SearchResults.this, PropertyDetails.class);
        startActivity(intent);
    }
}
