package com.madhu.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created By Madhukar Reddy On Jun 13, 2016
 *
 */
public class MapExamples {

    public static void main(String[] args) {

        String a = "abc";
        String b = new String("abc");

        Map<String, Integer> map = new HashMap<String, Integer>();
        Integer first = map.put(a, 1);
        Integer second = map.put(b, 2);
        System.out.println(first);
        System.out.println(second);
        System.out.println(firstNonRepeatableCharacter("Madhukar Reddy M"));

    }

    public static Character firstNonRepeatableCharacter(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            charCount.put(c, charCount.containsKey(c) ? charCount.get(c) + 1 : 1);
        }

        Set<Entry<Character, Integer>> entrySet = charCount.entrySet();
        List<Entry<Character, Integer>> collect = entrySet.stream().filter(map -> map.getValue() == 1)
                .collect(Collectors.toList());
        return collect.stream().findFirst().get().getKey();

    }

}
