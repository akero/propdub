package com.acme.propdub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class ScheduleVisit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_visit);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.back_button);
            actionBar.setTitle("Schedule a Visit");}
        Spinner spinner;
        Spinner spinner1;
        Spinner spinner2;

        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);

        // Example: Populating the spinner with data
        String[] items = {"Option 1", "Option 2", "Option 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_dropdown_item, items);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);

        spinner.setAdapter(adapter);



        // Example: Retrieving the selected item from the spinner
        String selectedItem = spinner.getSelectedItem().toString();

        // Example: Populating the spinner with data
        String[] items1 = {"Option 1", "Option 2", "Option 3"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner1.setAdapter(adapter);

        // Example: Retrieving the selected item from the spinner
        String selectedItem1 = spinner.getSelectedItem().toString();


        // Example: Populating the spinner with data
        String[] items2 = {"Option 1", "Option 2", "Option 3"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner2.setAdapter(adapter);

        // Example: Retrieving the selected item from the spinner
        String selectedItem2 = spinner.getSelectedItem().toString();







        //blurring background image
      /*  ImageView imageView = findViewById(R.id.background_image6);
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_about_us);
        Bitmap blurredBitmap = BlurBuilder.blur(this, originalBitmap);
        imageView.setImageBitmap(blurredBitmap); */
    }
}