package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
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