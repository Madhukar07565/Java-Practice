package com.madhu;

public class LargeSeq {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 5, 6, 7 };
		int sum = 0;
		int x = 10;
		try {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < i; j++) {
					for (int k = 0; k < j; k++) {
						sum = arr[i] + arr[j] + arr[k];
						if (sum == x) {
							System.out.println("[" + arr[k] + arr[j] + arr[i]
									+ "]");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
