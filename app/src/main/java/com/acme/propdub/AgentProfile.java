package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


//TODO: Pass value of what property it is to PropertyDetails.class
//TODO: Add "contact" from wireframe to PropertyDetails.class
public class AgentProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_profile);


        ImageView imageView = findViewById(R.id.background_image1);
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_about_us);
        Bitmap blurredBitmap = BlurBuilder.blur(this, originalBitmap);
        imageView.setImageBitmap(blurredBitmap);
        //properties listed by agent button code
        View propertyRentButton = findViewById(R.id.property_listed_by_agent_button);

        // Set up click listeners for UI elements
        propertyRentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPropertyListedByAgent();
            }
        });
    }

//TODO: pass value of what property it is to PropertyDetails.class

    // Method to navigate to properties listed by agent
    private void openPropertyListedByAgent() {
        Intent intent = new Intent(AgentProfile.this, PropertyDetails.class);
        startActivity(intent);
    }
}
