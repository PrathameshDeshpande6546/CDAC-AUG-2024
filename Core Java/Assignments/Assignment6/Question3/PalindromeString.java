package com.sunbeam.assignment;

import java.util.Scanner;

public class PalindromeString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String a;
		String rev="";
		System.out.println("Enter String");
		a=sc.next().toLowerCase();
		for(int i=a.length()-1;i>=0;i--) {
		rev=rev+a.charAt(i);
		}
		if(a.equals(rev)) {
			System.out.println("String is Palindrome");
		} else {
			System.out.println("String is not Palindrome");
		}
	}

}
