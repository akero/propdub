package com.acme.propdub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.maps.MapView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Support extends AppCompatActivity {
MapView mapView;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

try{
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back_button);
        actionBar.setTitle("Contact");
    }
}catch(Exception e){
    Log.d("tag9",e.toString());
}
        mapView = findViewById(R.id.map_view);
            mapView.onCreate(savedInstanceState);

        Spinner countrySpinner = findViewById(R.id.totalAmountEditText3);

// Create a list of countries
        List<String> countries = new ArrayList<>();
        String[] allCountries = {
                "Afghanistan",
                "Albania",
                "Algeria",
                "Andorra",
                "Angola",
                "Antigua and Barbuda",
                "Argentina",
                "Armenia",
                "Australia",
                "Austria",
                "Azerbaijan",
                "Bahamas",
                "Bahrain",
                "Bangladesh",
                "Barbados",
                "Belarus",
                "Belgium",
                "Belize",
                "Benin",
                "Bhutan",
                "Bolivia",
                "Bosnia and Herzegovina",
                "Botswana",
                "Brazil",
                "Brunei",
                "Bulgaria",
                "Burkina Faso",
                "Burundi",
                "Cabo Verde",
                "Cambodia",
                "Cameroon",
                "Canada",
                "Central African Republic",
                "Chad",
                "Chile",
                "China",
                "Colombia",
                "Comoros",
                "Congo (Brazzaville)",
                "Congo (Kinshasa)",
                "Costa Rica",
                "Croatia",
                "Cuba",
                "Cyprus",
                "Czech Republic",
                "Denmark",
                "Djibouti",
                "Dominica",
                "Dominican Republic",
                "East Timor",
                "Ecuador",
                "Egypt",
                "El Salvador",
                "Equatorial Guinea",
                "Eritrea",
                "Estonia",
                "Eswatini",
                "Ethiopia",
                "Fiji",
                "Finland",
                "France",
                "Gabon",
                "Gambia",
                "Georgia",
                "Germany",
                "Ghana",
                "Greece",
                "Grenada",
                "Guatemala",
                "Guinea",
                "Guinea-Bissau",
                "Guyana",
                "Haiti",
                "Honduras",
                "Hungary",
                "Iceland",
                "India",
                "Indonesia",
                "Iran",
                "Iraq",
                "Ireland",
                "Israel",
                "Italy",
                "Ivory Coast",
                "Jamaica",
                "Japan",
                "Jordan",
                "Kazakhstan",
                "Kenya",
                "Kiribati",
                "Korea, North",
                "Korea, South",
                "Kosovo",
                "Kuwait",
                "Kyrgyzstan",
                "Laos",
                "Latvia",
                "Lebanon",
                "Lesotho",
                "Liberia",
                "Libya",
                "Liechtenstein",
                "Lithuania",
                "Luxembourg",
                "Madagascar",
                "Malawi",
                "Malaysia",
                "Maldives",
                "Mali",
                "Malta",
                "Marshall Islands",
                "Mauritania",
                "Mauritius",
                "Mexico",
                "Micronesia",
                "Moldova",
                "Monaco",
                "Mongolia",
                "Montenegro",
                "Morocco",
                "Mozambique",
                "Myanmar",
                "Namibia",
                "Nauru",
                "Nepal",
                "Netherlands",
                "New Zealand",
                "Nicaragua",
                "Niger",
                "Nigeria",
                "North Macedonia",
                "Norway",
                "Oman",
                "Pakistan",
                "Palau",
                "Palestine",
                "Panama",
                "Papua New Guinea",
                "Paraguay",
                "Peru",
                "Philippines",
                "Poland",
                "Portugal",
                "Qatar",
                "Romania",
                "Russia",
                "Rwanda",
                "Saint Kitts and Nevis",
                "Saint Lucia",
                "Saint Vincent and the Grenadines",
                "Samoa",
                "San Marino",
                "Sao Tome and Principe",
                "Saudi Arabia",
                "Senegal",
                "Serbia",
                "Seychelles",
                "Sierra Leone",
                "Singapore",
                "Slovakia",
                "Slovenia",
                "Solomon Islands",
                "Somalia",
                "South Africa",
                "South Sudan",
                "Spain",
                "Sri Lanka",
                "Sudan",
                "Suriname",
                "Sweden",
                "Switzerland",
                "Syria",
                "Taiwan",
                "Tajikistan",
                "Tanzania",
                "Thailand",
                "Togo",
                "Tonga",
                "Trinidad and Tobago",
                "Tunisia",
                "Turkey",
                "Turkmenistan",
                "Tuvalu",
                "Uganda",
                "Ukraine",
                "United Arab Emirates",
                "United Kingdom",
                "United States",
                "Uruguay",
                "Uzbekistan",
                "Vanuatu",
                "Vatican City",
                "Venezuela",
                "Vietnam",
                "Yemen",
                "Zambia",
                "Zimbabwe"
        };

        countries.addAll(Arrays.asList(allCountries));
// Add more countries as needed

// Create an ArrayAdapter for the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_dropdown_item, countries);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);

// Set the adapter for the Spinner
        countrySpinner.setAdapter(adapter);

        //Set "United Arab Emirates" as the preselected option
        int spinnerPosition = adapter.getPosition("United Arab Emirates");
        countrySpinner.setSelection(spinnerPosition);

        EditText name, phone, email, message;
        name = findViewById(R.id.totalAmountEditText);
        phone = findViewById(R.id.totalAmountEditText1);
        email = findViewById(R.id.totalAmountEditText2);
        message = findViewById(R.id.totalAmountEditText4);


        submit= findViewById(R.id.button);

        CheckBox checkbox;
        checkbox= findViewById(R.id.checkbox_id);


        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String name1= name.getText().toString();
                String phone1= phone.getText().toString();
                String email1= email.getText().toString();
                String message1= message.getText().toString();

                if(TextUtils.isEmpty(email1)){
                    Toast.makeText(Support.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }
                // Check if the input is a valid email
                else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
                    // Input is not a valid email, show a message to the user
                    Toast.makeText(Support.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(name1)){
                    Toast.makeText(Support.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(phone1)){
                    Toast.makeText(Support.this, "Please enter your number", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(message1)){
                    Toast.makeText(Support.this, "Please enter your message", Toast.LENGTH_SHORT).show();
                }
                else if(checkbox.isChecked()==false){
                    Toast.makeText(Support.this, "Please accept the GDPR agreement", Toast.LENGTH_SHORT).show();
                }
                else{
                    //continue with login
                    //TODO: add backend handling and comment

                    Toast.makeText(Support.this, "Message sent", Toast.LENGTH_SHORT).show();
                    //Intent intent= new Intent(Support.this, MainActivity.class);
                    //startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
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