package com.madhu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created By Madhukar Reddy On May 30, 2016
 *
 */
public class NonRepeatableChracter {

    public static void main(String[] args) {

        String name = "steelershoware you";

        System.out.println("non repeatable chars are ");
        for (Character string : nonRepeatableCharacter(name)) {
            System.out.println(string);
        }
        System.out.println("first non repeatable char is " + nonRepeatableCharacter(name).get(0));
    }

    public static List<Character> nonRepeatableCharacter(String name) {
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

        List<Character> nonRepeatableChars = new ArrayList<Character>();
        
        map.forEach((ch, i) -> {
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        });

        for (Character ch : name.toCharArray()) {
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        }

        for (Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                nonRepeatableChars.add(entry.getKey());
            }
        }
        return nonRepeatableChars;
    }

}
