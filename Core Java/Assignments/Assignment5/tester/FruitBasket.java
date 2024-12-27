package com.app.tester;

import java.util.Scanner;

import com.app.fruits.Apple;
import com.app.fruits.Fruit;
import com.app.fruits.Mango;
import com.app.fruits.Orange;

public class FruitBasket {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array");
		int n = sc.nextInt();
		Fruit[] arr = new Fruit[n];
		int count = 0;
		int choice;

		for (;;) {

			System.out.println("----------------------------------------------");
			System.out.println("0.Exit");
			System.out.println("1.Add Mango");
			System.out.println("2.Add Orange");
			System.out.println("3.Add Apple");
			System.out.println("4.Show Fruits in Basket");
			System.out.println("5.Show Fruit details");
			System.out.println("6.Display taste all stale fruits in basket");
			System.out.println("7.Mark Fruit as Stale(Not fresh)");
			System.out.println("8.Mark all sour fruits stale");
			System.out.println("----------------------------------------------");
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();
			switch (choice) {
			case 0:
				System.out.println("Program Stopped");
				System.exit(0);
				break;
			case 1:
				if (count < n) {
					arr[count] = new Mango();
					arr[count].setName("Mango");
					arr[count].accept(sc);
					count++;
				} else {
					System.out.println("Array is full");
				}
				break;

			case 2:
				if (count < n) {
					arr[count] = new Orange();
					arr[count].setName("Orange");
					arr[count].accept(sc);
					count++;
				} else {
					System.out.println("Array is full");
				}

				break;
			case 3:
				if (count < n) {
					arr[count] = new Apple();
					arr[count].setName("Apple");
					arr[count].accept(sc);
					count++;
				} else {
					System.out.println("Array is full");
				}
				break;
			case 4:
				for (int i = 0; i < count; i++) {
					if (arr[i] != null) {
						System.out.println(arr[i].getName());
					} else {
						System.out.println("No fruit");
					}
				}
				break;
			case 5:

				for (int i = 0; i < count; i++) {
					if (arr[i].isFresh() == true) {

						System.out.println("Name:" + arr[i].getName());
						System.out.println("Color:" + arr[i].getColor());
						System.out.println("Weight:" + arr[i].getWeight());
						System.out.println("Taste: " + arr[i].taste());
					}
				}

				break;
			case 6:
				for (int i = 0; i < count; i++) {
					if (arr[i].isFresh() == false) {
						System.out.println(arr[i].getName());
						System.out.println(arr[i].taste());
					}
				}
				break;
			case 7:
				for (int i = 0; i < count; i++) {
					arr[i].display();
				}
				System.out.println("Enter index");
				int index = sc.nextInt();
				if (index >= 0 && index < count) {
					if (arr[index] != null) {
						arr[index].setFresh(false);
					}
				} else {
					System.out.println("Index does not exist");
				}

				System.out.println("Fruit marked as stale");
				break;
			case 8:

				for (int i = 0; i < count; i++) {
					if (arr[i].taste().equals("Sour")) {
						arr[i].setFresh(false);

					}
				}
				System.out.println("Fruits marked as stale");

				break;

			}
		}

	}

}
