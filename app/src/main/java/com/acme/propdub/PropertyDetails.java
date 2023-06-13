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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
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

            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeAsUpIndicator(R.drawable.back_button);
                actionBar.setTitle("Property Details");}

            ConstraintLayout rootLayout = findViewById(R.id.root_layout);

            ViewPager2 viewPager = findViewById(R.id.viewPager1);
            ImageAdapter1 adapter = new ImageAdapter1(this, imageIds);
            viewPager.setAdapter(adapter);

            //Code for video
            WebView webView = findViewById(R.id.youtube_video1);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            //feed this the correct video id

            String youtube_key=getString(R.string.youtube_key);
            String videoId = "YOUR_YOUTUBE_VIDEO_ID";
            videoId = "9bZkp7q19f0";
            String html = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" + videoId + "\" frameborder=\"0\" allowfullscreen></iframe>"+ "&key=" + youtube_key;
            webView.loadData(html, "text/html", "utf-8");

        } catch (Exception e) {
            Log.d("tag4", e.toString());
        }

    //contact agent button code
    TextView contactAgent;
    contactAgent = findViewById(R.id.contact_agent);
    contactAgent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });

    //message agent button code
    ImageView messageAgent;
    messageAgent = findViewById(R.id.icon1111);
    messageAgent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });

    //video agent button code
    ImageView videoAgent;
    videoAgent = findViewById(R.id.icon111111);
    videoAgent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });

    //call agent button code
    ImageView callAgent;
    callAgent = findViewById(R.id.icon1111111);
    callAgent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });

//TODO

//5 property features at top of class
    ImageView feature1, feature2, feature3, feature4, feature5;
    feature1 = findViewById(R.id.icon11);
    feature2 = findViewById(R.id.icon12);
    feature3 = findViewById(R.id.icon13);
    feature4 = findViewById(R.id.icon14);
    feature5 = findViewById(R.id.icon15);

//12 facilities
    ImageView facility1, facility2, facility3, facility4, facility5, facility6, facility7, facility8, facility9, facility10;
    facility1 = findViewById(R.id.icon1);
    facility2 = findViewById(R.id.icon2);
    facility3 = findViewById(R.id.icon3);
    facility4 = findViewById(R.id.icon4);
    facility5 = findViewById(R.id.icon5);
    facility6 = findViewById(R.id.icon122);
    facility7 = findViewById(R.id.icon222);
    facility8 = findViewById(R.id.icon322);
    facility9 = findViewById(R.id.icon422);
    facility10 = findViewById(R.id.icon522);

    //documents

    TextView doc1, doc2;
    doc1 = findViewById(R.id.propdocs);
    doc2 = findViewById(R.id.propdocs1);

    ImageButton downloaddoc1, downloaddoc2;
    downloaddoc1 = findViewById(R.id.button_after_text);
    downloaddoc2 = findViewById(R.id.downloadbutton);

//TODO
    downloaddoc1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //download pdf
            openDocViewerActivity();
        }
    });


    downloaddoc2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //download pdf
            openDocViewerActivity();
        }
    });

    TextView address = findViewById(R.id.address);


    //see all button code
    TextView seeAll;
    seeAll = findViewById(R.id.see_all);
    seeAll.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //all reviews
        }
    });

    //price of property
    TextView price = findViewById(R.id.costofproperty);
    //price.setText("\u062F.\u0625"+"");

    //book now button
    Button booknow = findViewById(R.id.booknow);
    booknow.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //connect to api to book
        }
    });

    //overview description
    TextView overview = findViewById(R.id.propertyDetails);
    //overview.setText("");

    //agentdetails link
    TextView agentdetails = findViewById(R.id.agent_name);
    ImageView agentimage = findViewById(R.id.agent_pic);

    agentdetails.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openAgentProfileActivity();
        }
    });

    agentimage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openAgentProfileActivity();
        }
    });

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

    private void openAgentProfileActivity(){
        Intent intent= new Intent(PropertyDetails.this, AgentProfile.class);
        //putextra required
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