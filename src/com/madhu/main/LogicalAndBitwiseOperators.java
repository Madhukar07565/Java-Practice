package com.madhu.main;

/**
 * Created By Madhukar Reddy On Jul 22, 2015
 *
 */
public class LogicalAndBitwiseOperators {

    public static void main(String[] args) {

        LogicalAndBitwiseOperators l = new LogicalAndBitwiseOperators();

        if (l.checkA("&&") && l.checkB("&&")) {
            System.out.println("here");
        }

        if (l.checkA("&") & l.checkB("&")) {
            System.out.println("Hey");
        }
        
        if(l.checkA("||") || l.checkB("||")) {
            System.out.println("here or");
        }
        
        if(l.checkA("|") | l.checkB("|")) {
            System.out.println("Hey or");
        }

    }

    boolean checkA(String from) {
        System.out.println("Checking a "+from);
        return false;
    }

    boolean checkB(String from) {
        System.out.println("Checking b "+from);
        return true;
    }
}
