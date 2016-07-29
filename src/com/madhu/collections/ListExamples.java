package com.madhu.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.ListUtils;

/**
 * Created By Madhukar Reddy On Jun 18, 2015
 *
 */
public class ListExamples {

    public static void main(String[] args) {
        
        Set<String> set = new HashSet<>();
        
        System.out.println(set.stream().findFirst().isPresent());
        
        /*List<String> l = new ArrayList<String>();
        l.add("a");
        l.add("b");
        l.add("c");
        l.add("d");
        l.add("e");
        List<String> l1 = new ArrayList<String>();
        l1.add("a");
        l1.add("e");
        System.out.println(">>>"+ListUtils.retainAll(l, l1));
        System.out.println("size is >> "+l.size());
        
        String s = "lovaq";
        String s1 = "lovez";
        
        for (int i=0; s.length() > s1.length() ? (i<s.length()) : (i<s1.length()); i++) {
            if(!(s1.charAt(i) == s.charAt(i))) {
                System.out.println(s.charAt(i));
                System.out.println(s1.charAt(i));
            }
        }*/
    }
    
}
