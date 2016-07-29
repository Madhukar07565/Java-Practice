package com.madhu;

public class Test2 extends Test1 {
    int a = 30;

    public void display() {
        super.display();
        System.out.println(a);
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        t.display();
    }
}
