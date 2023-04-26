package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class ScheduleVisit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_visit);

        //blurring background image
        ImageView imageView = findViewById(R.id.background_image6);
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_about_us);
        Bitmap blurredBitmap = BlurBuilder.blur(this, originalBitmap);
        imageView.setImageBitmap(blurredBitmap);
    }
}