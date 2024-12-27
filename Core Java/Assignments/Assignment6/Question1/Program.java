package com.sunbeam.entity;

import java.util.Scanner;

import com.sunbeam.exceptions.ExceptionLineTooLongException;

public class Program {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
		accept(sc);
		}catch(ExceptionLineTooLongException e){
			e.printStackTrace();
			
		}
	}	

	public static void accept(Scanner sc) throws ExceptionLineTooLongException{
		
		System.out.println("Enter String: ");
		String a=sc.nextLine();
		int l=a.length();
		if(l>80) {
			throw new ExceptionLineTooLongException("The String line is too long");
		}
		else {
			System.out.println("Length of string: "+l);
		}
		
	}
	}