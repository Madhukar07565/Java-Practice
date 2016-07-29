package com.madhu.collections;

import java.util.ArrayList;
import java.util.List;
import org.magicwerk.brownies.collections.GapList;

/**
 * Created By Madhukar Reddy On Jul 10, 2015
 *
 */
public class GapListExample {

    public static void main(String[] args) {
        gapListProcessingTime();
        listProcessingTime();
    }

    private static void listProcessingTime() {
        List<String> list = new ArrayList<String>();
        long start = System.currentTimeMillis();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(3, "d");
        list.add(2, "e");
        System.out.println("insertion time taken for list >>> " + (System.currentTimeMillis() - start));
        long s = System.currentTimeMillis();
        System.out.println(list.get(2));
        System.out.println("retriving time for list >>>> " + (System.currentTimeMillis() - s));
    }

    public static void gapListProcessingTime() {
        GapList<String> list = new GapList<String>();
        long start = System.currentTimeMillis();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(3, "d");
        list.add(2, "e");
        System.out.println("insertion time taken for GapList >>> " + (System.currentTimeMillis() - start));
        long s = System.currentTimeMillis();
        System.out.println(list.get(2));
        System.out.println("retriving time for GapList >>>> " + (System.currentTimeMillis() - s));
    }
}
