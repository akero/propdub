package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class intermediate_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_intermediate_screen);


        ConstraintLayout rootLayout = findViewById(R.id.root_layout);

        // Create an ImageView and set its layout parameters
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        // Set the scale type and the background image
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.intermediatepic);

        // Add the ImageView as the first child of the root layout
        rootLayout.addView(imageView, 0);

        //lets go button code
        View letsgoButton = findViewById(R.id.lets_go_button);
        letsgoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

    }
    // Method to navigate to mainactivity
    private void openMainActivity() {

       // Log.d("tag1","In sale intent");
        Intent intent = new Intent(intermediate_screen.this, MainActivity.class);
       // Log.d("tag1","In sale intent 2");
        startActivity(intent);
    }
}