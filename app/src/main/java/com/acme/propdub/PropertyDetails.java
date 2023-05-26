package com.acme.propdub;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.gms.maps.MapView;
import com.google.android.material.navigation.NavigationView;

import jp.wasabeef.blurry.Blurry;

public class PropertyDetails extends AppCompatActivity {


    private ImageView menuIcon;
    private NavigationView navigationView;
    MapView mapView;

    private int[] imageIds = new int[]{R.drawable.propertyimage1, R.drawable.propertyimage2, R.drawable.propertyimage3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_property_details);
            mapView = findViewById(R.id.map_view);
            mapView.onCreate(savedInstanceState);


            ConstraintLayout rootLayout = findViewById(R.id.root_layout);
            //View blueTint = findViewById(R.id.blue_tint);

            //Blurry.with(this).radius(10).sampling(8).color(Color.argb(66, 0, 66, 116)).async().onto(rootLayout);


            /*ImageView imageView = findViewById(R.id.background_image3);
            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_about_us);
            Bitmap blurredBitmap = BlurBuilder.blur(this, originalBitmap);
            imageView.setImageBitmap(blurredBitmap); */

            ViewPager2 viewPager = findViewById(R.id.viewPager1);
            ImageAdapter1 adapter = new ImageAdapter1(this, imageIds);
            viewPager.setAdapter(adapter);

            //Code for video
            WebView webView = findViewById(R.id.youtube_video);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            //feed this the correct video id
            String videoId = "YOUR_YOUTUBE_VIDEO_ID";
            videoId = "https://www.youtube.com/watch?v=9bZkp7q19f0";
            String html = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" + videoId + "\" frameborder=\"0\" allowfullscreen></iframe>";
            webView.loadData(html, "text/html", "utf-8");

            //back button code
            View backButton = findViewById(R.id.back_button);
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

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

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
