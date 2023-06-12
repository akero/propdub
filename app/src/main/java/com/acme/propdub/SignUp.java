package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText email;
        EditText name;
        EditText password;

        Button btn;
        TextView signin;

        email= findViewById(R.id.totalAmountEditText);
        name= findViewById(R.id.totalAmountEditText11);
        password= findViewById(R.id.totalAmountEditText1);
        btn= findViewById(R.id.btn);
        signin= findViewById(R.id.txt5);

        //setting onclicklisteners to the buttons
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(SignUp.this, login.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){

                        String email1= email.getText().toString();
                        String name1=  name.getText().toString();
                        String password1= password.getText().toString();

                        if(TextUtils.isEmpty(email1)){
                            Toast.makeText(SignUp.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                        }
                        else if(TextUtils.isEmpty(name1)){
                                Toast.makeText(SignUp.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                            }
                        else if(TextUtils.isEmpty(password1)){
                                    Toast.makeText(SignUp.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                                }
                        else{
                            //continue with login
                            //TODO: add backend handling

                            Intent intent= new Intent(SignUp.this, MainActivity.class);
                            startActivity(intent);
                                }
                        }
        });



    }
}