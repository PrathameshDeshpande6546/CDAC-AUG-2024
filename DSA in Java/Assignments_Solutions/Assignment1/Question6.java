package com.sunbeam.assignment;

public class Question6 {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, -1, 2, 1, 0, 4, -1, 7, 8 };
		int rep = 0;
		int index = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			rep = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					if (i != j)
						rep++;
				}
			}
			if (rep == 0) {
				System.out.println("Non Repeating first element is: " + arr[i]);
				break;
			}
		}
	}
}
