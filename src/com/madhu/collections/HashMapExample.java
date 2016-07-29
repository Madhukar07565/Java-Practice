package com.madhu.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    
    public static void main(String[] args) {
        Map<Integer, String> m = new HashMap<Integer, String>();
        m.put(1, "a");
        m.put(1, "b");
        m.put(2, "c");
        String s = m.put(3, "d");
        String s1 = m.put(3, "e");
        m.put(3, "f");
        m.put(4, "g");

        System.out.println("s is  >> "+s);
        System.out.println("s1 is >> "+s1);
        System.out.println("Map size >>> " + m.size());
        System.out.println("map key1 get >> " + m.get(4));
        System.out.println("map key3 get >> " + m.get(3));

    }
}
