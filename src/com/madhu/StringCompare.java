package com.madhu;

import java.util.*;

public class StringCompare {
	public static void main(String a[]) {
		long startTime = System.currentTimeMillis();
		StringBuffer result = new StringBuffer();
		String s1 = "Madhukar Reddy";
		StringTokenizer st = new StringTokenizer(s1, " ");
		while (st.hasMoreTokens()) {
			StringBuffer s = new StringBuffer(st.nextToken());
			result.append(s.reverse() + " ");
		}
		System.out.println(result.toString());
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}
}
