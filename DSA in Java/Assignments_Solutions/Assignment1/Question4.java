package com.sunbeam.assignment;

import java.util.Scanner;

public class Question4 {

	private static int binarySearch(int arr[], int key) {
		int left = 0;
		int right = arr.length - 1;
		int mid;
		int index = -1;
		while (left <= right) {
			mid = (left + right) / 2;
			if (key == arr[mid]) {
				index = 1;
				System.out.println("Key found at index: " + mid);
				return index;

			} else if (key < arr[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}
		return index;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = { 90, 80, 70, 60, 40 };

		System.out.println("Binary Search");
		System.out.println("Enter key to search");
		int key = sc.nextInt();
		int index = binarySearch(arr, key);
		if (index == -1) {
			System.out.println("Key not found");
		}

	}

}
