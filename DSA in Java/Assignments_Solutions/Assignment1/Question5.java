package com.sunbeam.assignment;

import java.util.Scanner;

public class Question5 {
	private static Scanner sc = new Scanner(System.in);

	private static int checkOccurance(int arr[], int key, int occ) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (key == arr[i]) {
				count++;
			}
			if (occ == count) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 34, 90, 87, 45, 23, 34, 90, 34, 45 };
		System.out.println("Enter Occurance:");
		int occ = sc.nextInt();
		System.out.println("Enter element to find their occurance");
		int key = sc.nextInt();
		int in = checkOccurance(arr, key, occ);
		if (in != -1) {
			System.out.println(occ + " Occurance of key " + key + " is found at index " + in);

		} else {
			System.out.println(occ + " Occurance of key " + key + " does not exist");
		}

	}

}
