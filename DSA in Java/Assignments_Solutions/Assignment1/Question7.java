package com.sunbeam.assignment;

import java.util.Scanner;

public class Question7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = { 10, 20, 15, 3, 4, 4, 1 };
		int rank = 0;
		System.out.println("Enter element to find its rank");
		int key = sc.nextInt();

		for (int i = 0; i < arr.length; i++) {
			if (key >= arr[i]) {
				rank++;

			}
		}
		System.out.println("Rank of Key " + key + " is " + rank);

	}

}
