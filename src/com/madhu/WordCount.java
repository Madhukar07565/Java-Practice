package com.madhu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class WordCount {

    public static void main(String[] args) {
        try {
            File f = new File("src/resources/a.txt");
            String file = f.getAbsolutePath();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            Map<String, Integer> map = wordCount(bufferedReader, stringBuffer);
            for (Entry<String, Integer> string : map.entrySet()) {
                System.out.println(string.getKey() + " 1=====1 "+string.getValue());
            }
            List<Entry<String, Integer>> list = sotrByValue(map);
            for (Map.Entry<String, Integer> entry : list) {
                System.out.println(entry.getKey() + " ====== " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> wordCount(BufferedReader bufferedReader, StringBuffer stringBuffer)
            throws IOException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
            StringTokenizer stringTokenizer = new StringTokenizer(stringBuffer.toString(), " ");
            while (stringTokenizer.hasMoreElements()) {
                String tmp = stringTokenizer.nextToken().toLowerCase();
                if (map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp) + 1);
                } else {
                    map.put(tmp, 1);
                }
            }
        }
        return map;
    }

    public static List<Entry<String, Integer>> sotrByValue(Map<String, Integer> m) {
        Set<Entry<String, Integer>> set = m.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return list;
    }
}
