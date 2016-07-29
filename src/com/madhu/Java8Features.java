package com.madhu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8Features {
    final static int c = 10;

    public static void main(String[] args) {
        System.out.println(Student.b);
        Student s1 = new Student();
        System.out.println(s1.a);
        //System.out.println(s1.b);
        Student s2 = new Student();
        System.out.println(s2.a);
        //System.out.println(s2.b);
        Arrays.asList("1", "2", "3").forEach(e -> System.out.println(e));
        List<String> list = new ArrayList<String>();
        list.add("ab");
        list.add("bc");
        list.add("cd");
        list.forEach(System.out::println);
    }
}

class Student {
    int a = 10;
    static int b = 10;

    public Student() {
        a++;
        b++;
    }
}
