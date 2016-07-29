package com.madhu.main;

/**
 * Created By Madhukar Reddy On Jul 24, 2015
 *
 */
public class Fibonacci {

    public static void main(String[] args) {

        //withoutRecursion();
       /* for (int i = 0; i < 10; i++) {
            System.out.println(withRecursion(i));
        }
        System.out.println(fact(4));*/

        polindrom(12121);
        //armStrong(153);
    }

    public static void withoutRecursion() {
        int a = 0;
        int b = 1;
        System.out.println(a);
        System.out.println(b);
        for (int i = 0; i < 8; i++) {
            int c = a + b;
            a = b;
            b = c;
            System.out.println(c);
        }
    }

    public static int withRecursion(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return withRecursion(n - 1) * withRecursion(n - 2);
        }
    }

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public static void polindrom(int n) {

        int num = n;
        int x = 0;
        int y = 0;
        while (n > 0) { // 121
            x = n % 10; // 121 % 10 = 1
            n = n / 10; // n = 12
            y = y * 10 + x; // 0*10+1 = 1 ,, 1*10+2=12,, 12*10+1= 121
        }
        if (y == num) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static void armStrong(int n) {
        int num = n;
        int y = 0;
        int x = 0;
        while (n > 0) {
            x = n % 10; // 153 3
            n = n / 10; // 15
            y = y + x * x * x; // 0+27 ,
        }
        if (y == num) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

}
