package com.acme.propdub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//TODO: Pass value of what property it is to PropertyDetails.class
//TODO: Add "contact" from wireframe to PropertyDetails.class
public class AgentProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_profile);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.back_button);
            actionBar.setTitle("Agent Details");}


        //contact agent button code
        TextView contactAgent;
        contactAgent= findViewById(R.id.contact_agent);
        contactAgent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        //message agent button code
        ImageView messageAgent;
        messageAgent= findViewById(R.id.icon1111);
        messageAgent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        //video agent button code
        ImageView videoAgent;
        videoAgent= findViewById(R.id.icon111111);
        videoAgent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        //call agent button code
        ImageView callAgent;
        callAgent= findViewById(R.id.icon1111111);
        callAgent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        //see all button code
        TextView seeAll;
        seeAll= findViewById(R.id.see_all);
        seeAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPropertyListedByAgent();
            }
        });
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

    //TODO: pass value of what property it is to PropertyDetails.class
    // Method to navigate to properties listed by agent
    private void openPropertyListedByAgent() {
        Intent intent = new Intent(AgentProfile.this, AgentListings.class);
        startActivity(intent);
    }
}