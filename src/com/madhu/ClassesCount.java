package com.madhu;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

public class ClassesCount {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter package name separated with /");
		String packageName = br.readLine();
		ArrayList<File> list = new ArrayList<File>();
		Enumeration<URL> urls = Thread.currentThread().getContextClassLoader()
				.getResources(packageName);
		while (urls.hasMoreElements()) {
			URL url = urls.nextElement();
			File file = new File(url.getFile());
			if (file.canRead()) {
				for (File f : file.listFiles()) {
					list.add(f);
				}
			}
			System.out.println("number of classes "+list.size());
			for (int i = 0; i < list.size(); i++) {
				System.out.println((i + 1) + " " + list.get(i).getName());
			}
		}

	}

}
