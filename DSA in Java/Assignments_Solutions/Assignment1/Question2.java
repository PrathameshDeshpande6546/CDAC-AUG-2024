package com.sunbeam.assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Question2 {
	private static void linearSearch(int arr[], int key) {

		System.out.println("Linear Search");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				System.out.println("Element found at index :" + i);

			} else {
				System.out.println("Comparison " + i + ": Key Not Found");
			}

		}

	}

	private static void binarySearch(int arr[], int key) {
		System.out.println("Binary Search");
		int left = 0;
		int right = arr.length - 1;
		int mid;

		while (left <= right) {
			mid = (left + right) / 2;
			if (key == arr[mid]) {
				System.out.println("Element found at index :" + mid);
				break;
			} else if (key < arr[mid]) {
				right = mid - 1;

			} else {
				left = mid + 1;
			}
			System.out.println("Key Not Found");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = { 20, 80, 76, 23, 45, 12, 90 };
		System.out.println("Enter element to search");
		int key = sc.nextInt();

		linearSearch(arr, key);
		System.out.println();
		System.out.println();
		Arrays.sort(arr);
		binarySearch(arr, key);

	}
}
