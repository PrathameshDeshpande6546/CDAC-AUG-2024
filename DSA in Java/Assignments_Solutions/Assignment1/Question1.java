package com.sunbeam.assignment;

import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int arr[]= {34,80,34,54,22,90};
		int index=0;

		System.out.println("Enter Element to check last Occurance");
		int key=sc.nextInt();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==key) {
				index=i;
			}
		}
		System.out.println("Index of Last Occurance of "+key+" is "+index);
		
	}

}
