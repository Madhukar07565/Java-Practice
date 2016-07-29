package com.madhu;

import java.util.*;

public class StringPermutations {
	public static Set<String> permFind(String str) {
		Set<String> perm = new HashSet<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		}
		char initial = str.charAt(0);
		String rem = str.substring(1);
		System.out.println(rem);
		Set<String> words = permFind(rem);
		for (String strnew : words) {
			for (int i = 0; i <= strnew.length(); i++) {
				perm.add(charinsert(strnew, initial, i));
			}
		}
		return perm;
	}

	public static String charinsert(String str, char c, int j) {
		String begin = str.substring(0, j);
		String end = str.substring(j);
		return begin + c + end;
	}

	public static void main(String a[]) {
		int c = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter to find perm");
		HashSet<String> s1 = (HashSet<String>) permFind(scan.next());
		Iterator<String> it = s1.iterator();
		System.out.println("\n perms are");
		scan.close();

		while (it.hasNext()) {
			System.out.print(it.next() + " ");
			c++;
		}
		System.out.println(c);
	}
}
