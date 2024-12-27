package com.sunbeam.assignment;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String a;
		String rev="";
		
		System.out.println("Enter String");
		a=sc.next().toLowerCase();
		
		System.out.println("Before Reverse: "+a);
		
		for(int i=a.length()-1;i>=0;i--) {
		rev=rev+a.charAt(i);
		}
		System.out.println("After Reverse: "+rev);
		
		
	}

}
