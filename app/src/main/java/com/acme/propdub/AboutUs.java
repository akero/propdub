package com.acme.propdub;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import jp.wasabeef.blurry.Blurry;

import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import jp.wasabeef.blurry.Blurry;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        //data for 4 headings
        TextView propdub, ourvision, ourmission, objective;
        propdub = findViewById(R.id.about_us_text);
        ourvision = findViewById(R.id.about_us_text1);
        ourvision= findViewById(R.id.about_us_text2);
        objective = findViewById(R.id.about_us_text3);



        
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
