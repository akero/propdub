package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import jp.wasabeef.blurry.Blurry;

//Taking inputs in edittext and passing values to MortgageCalculatorCode to calculate values
public class MortgageCalculator extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("#.##");
    private EditText totalAmountEditText, downPaymentEditText, interestRateEditText, loanTermEditText, propertyTaxEditText, homeInsuranceEditText, pmiEditText;
    private Button calculateButton;
    private TextView monthlyMortgageTextView, principalAndInterestTextView, monthlyPropertyTaxTextView, monthlyHomeInsuranceTextView, monthlyPMITextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_calculator);
        View blueTint = findViewById(R.id.blue_tint);
        ConstraintLayout rootLayout = findViewById(R.id.root_layout);

        //back button code
        View backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        Blurry.with(this).radius(10).sampling(8).color(Color.argb(66, 0, 66, 116)).async().onto(rootLayout);


        ImageView imageView = findViewById(R.id.background_image3);
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_about_us);
        Bitmap blurredBitmap = BlurBuilder.blur(this, originalBitmap);
        imageView.setImageBitmap(blurredBitmap);




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

                //trimming to two decimal points
                String formattedValue = df.format(monthlyMortgage);
                monthlyMortgage = Double.parseDouble(formattedValue);
                formattedValue = df.format(principalAndInterest);
                principalAndInterest = Double.parseDouble(formattedValue);
                formattedValue = df.format(monthlyPropertyTax);
                monthlyPropertyTax = Double.parseDouble(formattedValue);
                formattedValue = df.format(monthlyHomeInsurance);
                monthlyHomeInsurance = Double.parseDouble(formattedValue);
                formattedValue = df.format(monthlyPMI);
                monthlyPMI = Double.parseDouble(formattedValue);

                //setting textview
                monthlyMortgageTextView.setText("Monthly Mortgage: " + String.format("%.2f", monthlyMortgage));
                principalAndInterestTextView.setText("Principal and Interest: " + String.format("%.2f", principalAndInterest));
                monthlyPropertyTaxTextView.setText("Monthly Property Tax: " + String.format("%.2f", monthlyPropertyTax));
                monthlyHomeInsuranceTextView.setText("Monthly Home Insurance: " + String.format("%.2f", monthlyHomeInsurance));
                monthlyPMITextView.setText("Monthly PMI: " + String.format("%.2f", monthlyPMI));
                Toast.makeText(MortgageCalculator.this, "Monthly Mortgage: " + monthlyMortgage, Toast.LENGTH_LONG).show();
            }
        });
try{
        View roundedRectangleView = findViewById(R.id.rounded_rectangle_container);
        Blurry.with(this)
                .radius(10)
                .sampling(8)
                .color(Color.argb(66, 0, 66, 116))
                .async()
                .onto((ViewGroup) roundedRectangleView);
    }catch (Exception e){
    Log.d("aaaaa",e.toString());
}}}