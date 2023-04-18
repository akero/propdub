package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MortgageCalculatorCode extends AppCompatActivity {
    private double totalAmount;
    private double downPayment;
    private double interestRate;
    private double loanTerm;
    private double propertyTax;
    private double homeInsurance;
    private double pmi;


   // @Override
    //protected void onCreate(Bundle savedInstanceState) {
     //   super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_mortgage_calculator_code);
    //}
    public MortgageCalculatorCode(double totalAmount, double downPayment, double interestRate, int loanTerm, double propertyTax, double homeInsurance, double pmi) {
        this.totalAmount = totalAmount;
        this.downPayment = downPayment;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
        this.propertyTax = propertyTax;
        this.homeInsurance = homeInsurance;
        this.pmi = pmi;
    }
    public double calculateMonthlyMortgage() {
        double loanAmount = totalAmount - downPayment;
        double monthlyInterestRate = interestRate / (12 * 100);
        double totalMonths = loanTerm * 12;

        double principalAndInterest = loanAmount * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalMonths)) / (Math.pow(1 + monthlyInterestRate, totalMonths) - 1);
        double monthlyPropertyTax = propertyTax / 12;
        double monthlyHomeInsurance = homeInsurance / 12;
        double monthlyPMI = (loanAmount * pmi) / 12;

        return principalAndInterest + monthlyPropertyTax + monthlyHomeInsurance + monthlyPMI;
    }

    public double calculatePrincipalAndInterest() {
        double loanAmount = totalAmount - downPayment;
        double monthlyInterestRate = interestRate / (12 * 100);
        double totalMonths = loanTerm * 12;

        return loanAmount * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalMonths)) / (Math.pow(1 + monthlyInterestRate, totalMonths) - 1);
    }

    public double calculatePropertyTax() {
        return propertyTax / 12;
    }

    public double calculateHomeInsurance() {
        return homeInsurance / 12;
    }

    public double calculatePMI() {
        double loanAmount = totalAmount - downPayment;
        return (loanAmount * pmi) / 12;
    }
}