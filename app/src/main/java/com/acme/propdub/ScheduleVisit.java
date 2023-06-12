package com.acme.propdub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

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

//TODO: implement the 3 spinners
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);

        // Example: Populating the spinner with data
        String[] items = {"Option 1", "Option 2", "Option 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_dropdown_item, items);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        EditText name, phone, email, message;
        name= findViewById(R.id.editText0);
        phone= findViewById(R.id.editText1);
        email= findViewById(R.id.editText2);
        message= findViewById(R.id.edittext3);


        Button btn;
        btn= findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String name1, phone1, email1, message1;
                name1= name.getText().toString();
                phone1= phone.getText().toString();
                email1= email.getText().toString();
                message1= message.getText().toString();

                if(TextUtils.isEmpty(email1)){
                    Toast.makeText(ScheduleVisit.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }
                // Check if the input is a valid email
                else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
                    // Input is not a valid email, show a message to the user
                    Toast.makeText(ScheduleVisit.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(name1)){
                    Toast.makeText(ScheduleVisit.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(phone1)){
                    Toast.makeText(ScheduleVisit.this, "Please enter your number", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(message1)){
                    Toast.makeText(ScheduleVisit.this, "Please enter your message", Toast.LENGTH_SHORT).show();
                }else {
                //TODO: change this
                Toast.makeText(ScheduleVisit.this, "Your visit has been scheduled!", Toast.LENGTH_LONG).show();
            }
            }
        }
        );

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