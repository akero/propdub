package com.acme.propdub;

public class MortgageCalculatorCode {
    private double totalAmount;
    private double downPayment;
    private double interestRate;
    private double loanTerm;
    private double propertyTax;
    private double homeInsurance;
    private double pmi;

    public MortgageCalculatorCode(double totalAmount, double downPayment, double interestRate, int loanTerm, double propertyTax, double homeInsurance, double pmi) {
        this.totalAmount = totalAmount;
        this.downPayment = downPayment;
        this.interestRate = interestRate / 100.0; // Convert to percentage
        this.loanTerm = loanTerm;
        this.propertyTax = propertyTax;
        this.homeInsurance = homeInsurance;
        this.pmi = pmi;
    }

    public double calculateMonthlyMortgage() {
        double principalAndInterest = calculatePrincipalAndInterest();
        double monthlyPropertyTax = calculatePropertyTax();
        double monthlyHomeInsurance = calculateHomeInsurance();
        double monthlyPMI = calculatePMI();

        return principalAndInterest + monthlyPropertyTax + monthlyHomeInsurance + monthlyPMI;
    }

    private double calculatePrincipalAndInterest() {
        double loanAmount = totalAmount - downPayment;
        double monthlyInterestRate = interestRate / 12.0;
        double totalMonths = loanTerm * 12;

        // Amortization formula
        double principalAndInterest = loanAmount *
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalMonths)) /
                (Math.pow(1 + monthlyInterestRate, totalMonths) - 1);

        return principalAndInterest;
    }

    private double calculatePropertyTax() {
        return propertyTax / 12.0;
    }

    private double calculateHomeInsurance() {
        return homeInsurance / 12.0;
    }

    private double calculatePMI() {
        if (downPayment / totalAmount < 0.2) {
            return (pmi * (totalAmount - downPayment)) / 12.0;
        } else {
            return 0;
        }
    }
}
