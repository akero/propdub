package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//Taking inputs in edittext and passing values to MortgageCalculatorCode to calculate values
public class MortgageCalculator extends AppCompatActivity{

    private EditText totalAmountEditText, downPaymentEditText, interestRateEditText, loanTermEditText, propertyTaxEditText, homeInsuranceEditText, pmiEditText;
    private Button calculateButton;
    private TextView monthlyMortgageTextView, principalAndInterestTextView, monthlyPropertyTaxTextView, monthlyHomeInsuranceTextView, monthlyPMITextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_calculator);

        totalAmountEditText = findViewById(R.id.totalAmountEditText);
        downPaymentEditText = findViewById(R.id.downPaymentEditText);
        interestRateEditText = findViewById(R.id.interestRateEditText);
        loanTermEditText = findViewById(R.id.loanTermEditText);
        propertyTaxEditText = findViewById(R.id.propertyTaxEditText);
        homeInsuranceEditText = findViewById(R.id.homeInsuranceEditText);
        pmiEditText = findViewById(R.id.pmiEditText);
        calculateButton = findViewById(R.id.calculateButton);
        monthlyMortgageTextView = findViewById(R.id.monthlyMortgageTextView);
        principalAndInterestTextView = findViewById(R.id.principalAndInterestTextView);
        monthlyPropertyTaxTextView = findViewById(R.id.monthlyPropertyTaxTextView);
        monthlyHomeInsuranceTextView = findViewById(R.id.monthlyHomeInsuranceTextView);
        monthlyPMITextView = findViewById(R.id.monthlyPMITextView);

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

                //calculating mortgage
                MortgageCalculatorCode mortgageCalculator = new MortgageCalculatorCode(totalAmount, downPayment, interestRate, loanTerm, propertyTax, homeInsurance, pmi);
                double monthlyMortgage = mortgageCalculator.calculateMonthlyMortgage();
                double principalAndInterest = mortgageCalculator.calculatePrincipalAndInterest();
                double monthlyPropertyTax = mortgageCalculator.calculatePropertyTax();
                double monthlyHomeInsurance = mortgageCalculator.calculateHomeInsurance();
                double monthlyPMI = mortgageCalculator.calculatePMI();


                monthlyMortgageTextView.setText("Monthly Mortgage: " + String.format("%.2f", monthlyMortgage));
                principalAndInterestTextView.setText("Principal and Interest: " + String.format("%.2f", principalAndInterest));
                monthlyPropertyTaxTextView.setText("Monthly Property Tax: " + String.format("%.2f", monthlyPropertyTax));
                monthlyHomeInsuranceTextView.setText("Monthly Home Insurance: " + String.format("%.2f", monthlyHomeInsurance));
                monthlyPMITextView.setText("Monthly PMI: " + String.format("%.2f", monthlyPMI));
                Toast.makeText(MortgageCalculator.this, "Monthly Mortgage: " + monthlyMortgage, Toast.LENGTH_LONG).show();
            }
        });




    }
}