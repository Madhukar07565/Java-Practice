package com.madhu.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Created By Madhukar On Jun 6, 2016
 *
 */
public class SetExample {
    
    public static void main(String[] args) {
        
        Set<String> strings = new HashSet<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        
        for (String string : strings) {
            System.out.println(string);
            break;
        }
        
        System.out.println(strings.stream().findFirst().get());
    }

}
