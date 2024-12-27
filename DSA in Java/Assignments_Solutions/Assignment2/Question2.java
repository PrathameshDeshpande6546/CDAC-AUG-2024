package com.sunbeam;

class Employee {
	int empid;
	String name;
	double salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empid, String name, double salary) {
		super();
		this.empid = empid;
		this.name = name;
		this.salary = salary;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", salary=" + salary + "]";
	}

}

public class Question2 {
	private static void sortbySalary(Employee arr[]) {
		for (int i = 1; i < arr.length; i++) {
			Employee curr = arr[i];
			int j;

			for (j = i - 1; j >= 0 && arr[j].getSalary() > curr.getSalary(); j--) {

				arr[j + 1] = arr[j];

			}
			arr[j + 1] = curr;

		}

	}

	public static void main(String[] args) {
		Employee arr[] = { new Employee(1, "Prathamesh", 90000), new Employee(5, "Pratik", 50000),
				new Employee(3, "Subhash", 20000), new Employee(2, "Darshan", 80000), new Employee(4, "Nilesh", 10000),
				new Employee(6, "Rushikesh", 30000) };
		System.out.println("Before Sorting - ");

		for (Employee e : arr) {
			System.out.println(e.toString());
		}

		sortbySalary(arr);
		System.out.println();

		System.out.println("After Sorting - ");
		for (Employee e1 : arr) {
			System.out.println(e1.toString());
		}

	}
}