package com.acme.propdub;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import jp.wasabeef.blurry.Blurry;
import android.widget.ImageView;
import android.widget.TextView;

import jp.wasabeef.blurry.Blurry;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ImageView imageView = findViewById(R.id.background_image);
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_about_us);
        Bitmap blurredBitmap = BlurBuilder.blur(this, originalBitmap);

        // Add a blue tint to the blurred bitmap
        int blueColor = Color.parseColor("#66004274"); // Adjust the color and transparency as needed
        PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(blueColor, PorterDuff.Mode.OVERLAY);
        imageView.setColorFilter(colorFilter);


        imageView.setImageBitmap(blurredBitmap);
        String about= "PropDub is a leading real estate platform in Dubai, connecting trusted developers and select agents with global buyers. Our expert-curated collection of genuine, high-quality investments keeps users updated on the best opportunities.\n" +
                "\n" +
                "Our experienced team of professionals, with backgrounds in UAE real estate, digital marketing, and advertising, is our greatest strength. We aim to fulfill global real estate needs by connecting individuals with trusted developers and agents while empowering informed decision-making.\n" +
                "\n" +
                "Our mission is to offer a comprehensive platform for UAE developers, ensuring quality customer service and making Dubai's property market accessible to all. Our objective is to provide genuine investment leads for residential, commercial, retail, and land sectors on our platform.\n" +
                "\n" +
                "At PropDub, we value integrity, clarity, promptness, and commitment, striving for mutual benefit for all parties involved.";
        TextView aboutUsText = findViewById(R.id.about_us_text);
        aboutUsText.setText(about);
    }
}
