/*
 *  Formula
 * M = P (i(1+i)^n / ((1+i)^n -1))
 * where M = monthly payment
 *P = principal amount means total amount
 *i = interest rate
 *n=number of payments
 * */

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    private static final int MONTHS_IN_YEAR = 12;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the principal amount: ");
        double principal = sc.nextDouble();
        System.out.println("Enter the annual interest rate: ");
        float interestRate = sc.nextFloat();
        interestRate = interestRate / 100;
        System.out.println("Enter the number of years: ");
        int years = sc.nextInt();

        sc.close();
        float monthlyInterestRate = interestRate / MONTHS_IN_YEAR;

        int numberOfPayments = years * MONTHS_IN_YEAR;

        double monthlyPayment = principal * (
                (monthlyInterestRate * (Math.pow(1+monthlyInterestRate, numberOfPayments))) /
                        (Math.pow(1+monthlyInterestRate, numberOfPayments)-1)
                );

        System.out.println("Monthly payment: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
        System.out.println("Total payback amount: " + NumberFormat.getCurrencyInstance().format(monthlyPayment * numberOfPayments));
    }
}

