package com.sunbeam.test;

import java.util.Scanner;

import com.sunbeam.entity.Employee;

public class EmployeeTest {
 public static void main(String args[]) {
	
	 Employee e1=new Employee();
	 Employee e2=new Employee();
	 
	 e1.accept();
	 System.out.println("2nd Employee");
	 e2.accept();
	 	System.out.println("Employee Details: ");
		System.out.println("FirstName"+"\t"+"LastName"+"\t"+"Salary"+"\t"+"AnnualSal"+"\t"+"10%IncAnnualSal");
		e1.display();
		e2.display();
		
		
		

	 
	 
	 
	 
	 
	 
	 
	 
 }
}
