/**
 * 
 */
package com.madhu.main;

/**
 * @author madhukar
 *
 */
public class TestA {

    static int a = 10;
    public static void main(String[] args) {
        a += 10; 
        System.out.println("from A class");
        //System.out.println(null); //The method println(char[]) is ambiguous for the type PrintStream
        System.out.println((String)null);//output : null
        System.out.println((Object)null);//output : null
        System.out.println(TestA.a);
        //System.out.println((char[])null);//Compiled succesfully but will get runtimeException(NullPointerException)
    }
}
