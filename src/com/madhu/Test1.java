package com.madhu;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Scanner;

public class Test1 extends Test {
    int a = 20;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter directory to search files ");
        String name = scanner.next();
        File file = new File(name);
        FilenameFilter filenameFilter = new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("a");
            }
        };
        scanner.close();
        File[] files = file.listFiles(filenameFilter);
        int c=0;
        for (File file2 : files) {
            if(!file2.isDirectory()) {
            System.out.println(file2);
            c++;
            }
        }
        System.out.println("no of files "+c);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("enter directory to search files ");
        String name1 = scanner1.next();
        Enumeration<URL> lists = ClassLoader.getSystemClassLoader().getResources(name1);
        while (lists.hasMoreElements()) {
            URL url = (URL) lists.nextElement();
            System.out.println(url.getFile());
            
        }
        scanner1.close();
    }
    
}
