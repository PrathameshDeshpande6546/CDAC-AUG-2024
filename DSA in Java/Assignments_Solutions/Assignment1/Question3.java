package com.sunbeam.assignment;

import java.util.Objects;
import java.util.Scanner;

class Employee {
	int empid;
	String name;

	public Employee() {
		super();
	}

	public Employee(int empid, String name) {
		super();
		this.empid = empid;
		this.name = name;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + "]";
	}

}

public class Question3 {

	private static int searchbyId(Employee arr[], Scanner sc) {
		System.out.println("Enter Empid to search Employee");
		int id = sc.nextInt();
		int index;
		for (int i = 0; i < arr.length; i++) {
			if (id == arr[i].getEmpid()) {
				index = 1;
				System.out.println(arr[i]);
				return index;
			}
		}
		return -1;
	}

	private static int searchbyName(Employee arr[], Scanner sc) {
		System.out.println("Enter name to search Employee");
		String empname = sc.next();
		int ind;
		for (int i = 0; i < arr.length; i++) {
			if (empname.equals(arr[i].getName())) {

				ind = 1;
				System.out.println(arr[i]);
				return ind;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee arr[] = new Employee[5];
		arr[0] = new Employee(1, "Prathamesh");
		arr[1] = new Employee(2, "Yashraj");
		arr[2] = new Employee(3, "Pranav");
		arr[3] = new Employee(4, "Indrajeet");
		arr[4] = new Employee(5, "Pratik");

		int choice;
		for (;;) {
			System.out.println("0.exit\n1.Search Employee by Id\n2.Search Employee by Name");
			System.out.print("Enter your Choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 0:
				System.exit(0);
				break;
			case 1:
				int index = searchbyId(arr, sc);
				if (index == -1)
					System.out.println("Employee id does not exist");

				break;
			case 2:
				int in = searchbyName(arr, sc);
				if (in == -1)
					System.out.println("Employee does not exist");
				break;
			default:
				System.out.println("Wrong Choice..");
				break;

			}
		}

	}

}
