package com.acme.propdub;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class PropertyDetails extends AppCompatActivity {

    private int[] imageIds = new int[]{R.drawable.propertyimage1, R.drawable.propertyimage2, R.drawable.propertyimage3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_property_details);

            ImageView imageView = findViewById(R.id.background_image3);
            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_about_us);
            Bitmap blurredBitmap = BlurBuilder.blur(this, originalBitmap);
            imageView.setImageBitmap(blurredBitmap);

            ViewPager2 viewPager = findViewById(R.id.viewPager1);
            ImageAdapter1 adapter = new ImageAdapter1(this, imageIds);
            viewPager.setAdapter(adapter);


            // contact button code
            View contactButton = findViewById(R.id.contact);
            contactButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openContactActivity();
                }
            });

            // mortgage calculator button code
            View mortgage_calculatorButton = findViewById(R.id.mortgage_calculator);
            mortgage_calculatorButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openMortgageActivity();
                }
            });

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

            // video button code
            View videoButton = findViewById(R.id.video);
            videoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //openPropertySaleActivity();
                }
            });

            // documents viewer button code
            View documentsViewerButton = findViewById(R.id.documents_viewer);
            documentsViewerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDocViewerActivity();
                }
            });
        } catch (Exception e) {
            Log.d("tag4", e.toString());
        }
    }

    // Method to navigate to DocViewer
    private void openDocViewerActivity() {
        Intent intent = new Intent(PropertyDetails.this, DocViewer.class);
        startActivity(intent);
    }

    private void openScheduleButtonActivity() {
        Intent intent = new Intent(PropertyDetails.this, ScheduleVisit.class);
        startActivity(intent);
    }

    private void openMortgageActivity() {
        Intent intent = new Intent(PropertyDetails.this, MortgageCalculator.class);
        startActivity(intent);
    }

    // Method to navigate to Contact
    private void openContactActivity() {
        Intent intent = new Intent(PropertyDetails.this, Contact.class);
        startActivity(intent);
    }
}
