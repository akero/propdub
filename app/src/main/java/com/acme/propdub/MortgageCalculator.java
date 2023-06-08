package com.acme.propdub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MortgageCalculator extends AppCompatActivity {

    private EditText totalAmountEditText, downPaymentEditText, interestRateEditText, loanTermEditText, propertyTaxEditText, homeInsuranceEditText, pmiEditText;
    private Button calculateButton;
    private TextView monthlyMortgageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_calculator);
try{
        totalAmountEditText = findViewById(R.id.totalAmountEditText);
        downPaymentEditText = findViewById(R.id.downPaymentEditText);
        interestRateEditText = findViewById(R.id.interestRateEditText);
        loanTermEditText = findViewById(R.id.loanTermEditText);
        propertyTaxEditText = findViewById(R.id.propertyTaxEditText);
        homeInsuranceEditText = findViewById(R.id.homeInsuranceEditText);
        pmiEditText = findViewById(R.id.pmiEditText);
        calculateButton = findViewById(R.id.calculateButton);
        monthlyMortgageTextView = findViewById(R.id.top_text);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.back_button);
            actionBar.setTitle("Mortgage Calculator");}

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double totalAmount = Double.parseDouble(totalAmountEditText.getText().toString());
                double downPayment = Double.parseDouble(downPaymentEditText.getText().toString());
                double interestRate = Double.parseDouble(interestRateEditText.getText().toString());
                int loanTerm = Integer.parseInt(loanTermEditText.getText().toString());
                double propertyTax = Double.parseDouble(propertyTaxEditText.getText().toString());
                double homeInsurance = Double.parseDouble(homeInsuranceEditText.getText().toString());
                double pmi = Double.parseDouble(pmiEditText.getText().toString());

                MortgageCalculatorCode mortgageCalculator = new MortgageCalculatorCode(totalAmount, downPayment, interestRate, loanTerm, propertyTax, homeInsurance, pmi);
                double monthlyMortgage = mortgageCalculator.calculateMonthlyMortgage();

                // Format to two decimal points
                DecimalFormat df = new DecimalFormat("#.00");
                String formattedMonthlyMortgage = df.format(monthlyMortgage);
                String dihramsymbol="\u062F.\u0625";

                monthlyMortgageTextView.setText("Monthly Mortgage: " +dihramsymbol+ " "+ formattedMonthlyMortgage);
                ScrollView scrollView = (ScrollView) findViewById(R.id.scroll);
                scrollView.fullScroll(ScrollView.FOCUS_UP);

                Toast.makeText(MortgageCalculator.this, "Monthly Mortgage: " + formattedMonthlyMortgage, Toast.LENGTH_LONG).show();
            }
        });
    }catch(Exception e){
        Log.d("tag11",e.toString());
    }
}}
