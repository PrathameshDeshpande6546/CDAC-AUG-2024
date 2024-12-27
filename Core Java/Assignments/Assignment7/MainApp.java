package com.sunbeam.tester;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import com.sunbeam.entity.Student;

class NameComp implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getName().compareTo(o2.getName());
	}
	}


class MarksComp implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return Double.compare(o2.getMarks(), o1.getMarks());
	}
}


	class CityComp implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			return o1.getCity().compareTo(o2.getCity());
		}
		
	}
	


public class MainApp {
	
	public static void display(Student[] arr) {
		System.out.println("--------------------------------------------------------------");
		for(Student s:arr) {
			System.out.println(s);
		}
		System.out.println("--------------------------------------------------------------");
		
	}
	
	public static int menu(Scanner sc) {
		System.out.println("0.Exit");
		System.out.println("1.Sort on their city(asc)");
		System.out.println("2.Sort on their marks(desc)");
		System.out.println("3.Sort on their name(asc)");
		System.out.println("4.Sort on the Rollno");
		return sc.nextInt();
	}
	
	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		Student[] arr=new Student[4];
	
		arr[0]=new Student(1,"Prathamesh","Kolhapur",98.90);
		arr[1]=new Student(2,"Anuj","Pune",90.80);
		arr[2]=new Student(3,"Darshan","Mumbai",88.78);
		arr[3]=new Student(4,"Satyam","Banglore",87.09);
		int choice;
		while((choice=menu(sc))!=0) {
			switch (choice) {
			
			case 1:
					CityComp ccomp=new CityComp();
					Arrays.sort(arr,ccomp);
					
				break;
				
			case 2:
					MarksComp mcomp=new MarksComp();
					Arrays.sort(arr,mcomp);
					
				break;
				
			case 3:	NameComp ncomp=new NameComp();
					Arrays.sort(arr,ncomp);
					
				break;
				
			case 4:Arrays.sort(arr);
					
				break;
			default: System.out.println("Invalid Choice..");
				break;
			}
			if(choice>=0 && choice<=4) {
				display(arr);
			}
		}
		
		
		
		
		
	}

}
