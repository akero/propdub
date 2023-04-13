package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//TODO: make all these functional
public class PropertyDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_details);


        // contact button code
        View contactButton = findViewById(R.id.contact);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContactActivity();
            }
        });


//TODO: add mortgage calculator to page

        // mortgage calculator button code
        View mortgage_calculatorButton = findViewById(R.id.mortgage_calculator);
        mortgage_calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openPropertySaleActivity();
            }
        });

//TODO: Add map on page

        // Location on map button code
        View locationOnMapButton = findViewById(R.id.location_on_map);
        locationOnMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //openPropertySaleActivity();
            }
        });

        // schedule button code
        View scheduleButton = findViewById(R.id.schedule_viewing);
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScheduleButtonActivity();
            }
        });

//TODO: Add video to page if it exists otherwise don't show this

        // video button code
        View videoButton = findViewById(R.id.video);
        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //openPropertySaleActivity();
            }
        });

//TODO: Add documents viewer to page

        // documents viewer button code
        View documentsViewerButton = findViewById(R.id.documents_viewer);
        documentsViewerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDocViewerActivity();
            }
        });
    }

    // Method to navigate to DocViewer
    private void openDocViewerActivity() {
        Intent intent = new Intent(PropertyDetails.this, DocViewer.class);
        startActivity(intent);
    };

    private void openScheduleButtonActivity() {
        Intent intent = new Intent(PropertyDetails.this, ScheduleVisit.class);
        startActivity(intent);
    };

    // Method to navigate to Contact
    private void openContactActivity() {
        Intent intent = new Intent(PropertyDetails.this, Contact.class);
        startActivity(intent);
    };
}