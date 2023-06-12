package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        EditText email;
        EditText password;

        Button btn;
        TextView forgotpass;
        TextView registernow;

        email = findViewById(R.id.totalAmountEditText);
        password= findViewById(R.id.totalAmountEditText1);

        btn= findViewById(R.id.btn);
        forgotpass= findViewById(R.id.txt3);
        registernow= findViewById(R.id.txt5);

        registernow.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View v){
                Intent intent= new Intent(login.this, SignUp.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String email1= email.getText().toString();
                String password1= password.getText().toString();

                if(TextUtils.isEmpty(email1)){
                    Toast.makeText(login.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }
                // Check if the input is a valid email
                else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
                    // Input is not a valid email, show a message to the user
                    Toast.makeText(login.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(password1)){
                    Toast.makeText(login.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                }
                else{
                    //continue with login
                    //TODO: add backend handling

                    Intent intent= new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
    }



