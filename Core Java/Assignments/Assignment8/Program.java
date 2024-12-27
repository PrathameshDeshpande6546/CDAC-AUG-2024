package com.sunbeam.project;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Program {
	private static void saveProjects(Set<Project> pList) {
		try (FileOutputStream fos = new FileOutputStream("Project.db")) {
			try (BufferedOutputStream bos = new BufferedOutputStream(fos)) {
				try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
					oos.writeObject(pList);

				}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static Set<Project> loadProjects() {
		try (FileInputStream fis = new FileInputStream("Project.db")) {
			try (BufferedInputStream bis = new BufferedInputStream(fis)) {
				try (ObjectInputStream ois = new ObjectInputStream(bis)) {
					Set<Project> pList = (Set<Project>) ois.readObject();
					return pList;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int menu(Scanner sc) {
		System.out.println("------------------------------------------------------------------");
		System.out.println("0.Exit");
		System.out.println("1. Add Projects in the Set");
		System.out.println("2. Input a Project from user and add in Set  ");
		System.out.println("3. Display all Projects in Set");
		System.out.println("4. Delete a Project by Id from Set");
		System.out.println("5. Copy All Projects from Set to ArrayList");
		System.out.println("6. Display all Projects from List");
		System.out.println("7. Sort all Projects in List by cost");
		System.out.println("8. Find project with Max team size using Collections.max()");
		System.out.println("9. Count all Projects of \"Java\" technology using Stream API");
		System.out.println("------------------------------------------------------------------");
		System.out.print("Enter your Choice: ");

		return sc.nextInt();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Set<Project> pList = loadProjects();

		List<Project> aList = new ArrayList<Project>();
		int choice = 0;
		Project p;

		while ((choice = menu(sc)) != 0) {
			switch (choice) {
			case 1:
				pList = new HashSet<Project>();
				pList.add(new Project(1, "Train Reservation System", 5, 5000000, "Java"));
				pList.add(new Project(2, "Airline Reservation System", 3, 6000000, ".NET"));
				pList.add(new Project(4, "Online Grocery Shop", 6, 3000000, "Java"));
				pList.add(new Project(5, "Online Book Shop", 2, 3000000, ".NET"));
				pList.add(new Project(3, "Online Jewelry Shop", 4, 4000000, "Java"));
				pList.add(new Project(2, "Bus Reservation System", 3, 3500000, "JS"));
				break;
			case 2:
				System.out.println("Enter Project Details");
				System.out.println("Project Id,Title,TeamSize,ProjectCost,Technology");
				pList.add(new Project(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.next()));
				break;
			case 3:
				pList.forEach(System.out::println);
				break;
			case 4:
				p = new Project();
				System.out.println("Enter Project Id to delete");
				int index = sc.nextInt();
				p.id = index;
				pList.remove(p);
				System.out.println("Project Deleted...");
				break;
			case 5:
				aList.addAll(pList);

				System.out.println("Set Copied to Array List");

				break;

			case 6:
				aList.forEach(System.out::println);
				break;

			case 7:
				aList.stream().sorted((x, y) -> Double.compare(x.projectCost, y.projectCost))
						.forEach(System.out::println);
				break;
			case 8:
				System.out.println(
						"Project with max team size: " + Collections.max(pList, (x, y) -> x.teamSize - y.teamSize));
				break;
			case 9:
				System.out.println(
						"Java Project: " + pList.stream().filter(x -> x.getTechnology().equals("Java")).count());
				break;

			default:
				System.out.println("Invalid Choice");
				break;
			}

		}
		saveProjects(pList);

	}

}
