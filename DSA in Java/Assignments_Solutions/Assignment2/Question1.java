package com.sunbeam;

import java.util.Arrays;

public class Question1 {
	private static void insertionsort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int curr = arr[i];
			int prev = i - 1;

			while (prev >= 0 && arr[prev] < curr) {
				arr[prev + 1] = arr[prev];
				prev--;
			}

			arr[prev + 1] = curr;

		}
	}

	public static void main(String[] args) {
		int arr[] = { 89, 90, 45, 12, 87, 54 };
		System.out.println("Inserion sort:");
		System.out.println("Before Sorting " + Arrays.toString(arr));
		insertionsort(arr);
		System.out.println("After Sorting in descending order " + Arrays.toString(arr));

	}

}
