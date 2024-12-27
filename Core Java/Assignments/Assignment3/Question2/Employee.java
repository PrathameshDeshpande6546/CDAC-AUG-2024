package com.sunbeam.entity;

import java.util.Scanner;

public class Employee {
 String firstName;
 String lastName;
 double salary;

public Employee(){
	firstName="Prathamesh";
	lastName="Deshpande";
	salary=500000;
}


public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public double getSalary() {
	return salary;
}

public void setSalary(double salary) {
	this.salary = salary;
}
public void accept() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter First Name");
	 setFirstName(sc.next());
	 System.out.println("Enter Last Name");
	 setLastName(sc.next());
	 System.out.println("Enter Salary");
	 salary=sc.nextDouble();
	 if(salary<0) {
		 setSalary(0);
	 }else {
	 setSalary(salary);
	 }
	 }
public void display() {
	System.out.println(getFirstName()+"\t"+getLastName()+"\t"+getSalary()+"\t"+yearlySalary()+"\t"+(yearlySalary()+(yearlySalary()*0.1)));
}

public double yearlySalary() {
	double total=getSalary()*12;
	return total;
}



}



