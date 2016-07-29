package com.madhu;

class Str {
	public static void main(String a[]) {
		String s = "madhukar";
		String s1 = "mujju";
		StringBuffer s2 = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s1.length(); j++) {
				if (s.charAt(i) == s1.charAt(j)) {
					s2.append(s1.charAt(i));
				}
			}
		}
		System.out.println(s2.toString());
	String[] str = new String[3];
	for(int i=0;i<3;i++)
	{
			str[i]="madhu";
	}
	System.out.println("Str is"+(Object)str);
	}
}