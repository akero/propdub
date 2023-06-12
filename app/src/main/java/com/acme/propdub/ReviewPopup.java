package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ReviewPopup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_popup);

        ImageView close;
        close= findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onBackPressed();
            }
        });

        Button submit, maybelater;
        submit= findViewById(R.id.button);
        maybelater= findViewById(R.id.button1);

        EditText message= findViewById(R.id.totalAmountEditText4);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //TODO
                String message1 = message.getText().toString();

                if (TextUtils.isEmpty(message1)) {
                    Toast.makeText(ReviewPopup.this, "Please enter your message", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ReviewPopup.this, ThankYou.class);
                    startActivity(intent);
                }
            }
        });

        maybelater.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onBackPressed();
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

}