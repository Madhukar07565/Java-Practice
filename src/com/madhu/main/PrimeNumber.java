package com.madhu.main;

import java.util.Scanner;

/**
 * Created By Madhukar Reddy On Jul 24, 2015
 *
 */
public class PrimeNumber {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("enter number to verify");
        int n = scan.nextInt();
        primeCheck(n);
        scan.close();
    }

    private static void primeCheck(int n) {
        int c = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                c++;
            }
        }
        if (c == 2) {
            System.out.println("Prime Number");
        } else {
            System.out.println("not prime number");
        }
    }
}
