package com.madhu.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created By Madhukar Reddy On Jun 18, 2015
 *
 */
public class ArrayListExample {
    
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("A");
        names.add("B");
        names.add(2, "C");
        
        System.out.println(names);
        System.out.println(names.get(0));
        //System.out.println(names.get(3));
        
        Iterator<String> itr = names.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
            //names.add("D");
        }
        
        System.out.println(names);
    }

}
