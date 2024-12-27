package com.app.fruits;

import java.util.Scanner;

public abstract class Fruit {
	String color;
	String name;
	double weight;
	boolean isFresh = true;

	public Fruit() {

	}

	public Fruit(String color, String name, double weight) {
		// super();
		this.color = color;
		this.name = name;
		this.weight = weight;

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isFresh() {
		return isFresh;
	}

	public void setFresh(boolean isFresh) {
		this.isFresh = isFresh;

	}

	public void accept(Scanner sc) {
		System.out.println("Enter fruit details");
		System.out.println("Weight: ");
		weight = sc.nextDouble();
		System.out.println("Color: ");
		color = sc.next();

	}

	public void display() {
		System.out.println("Fruit Name: " + name);
		System.out.println("Weight: " + weight);
		System.out.println("Color: " + color);
		System.out.println("Is Fruit fresh: " + isFresh);

	}

	public abstract String taste();

	@Override
	public String toString() {
		return "Fruit [color=" + color + ", name=" + name + ", weight=" + weight + ", isFresh=" + isFresh + ", Taste="
				+ taste() + "]";
	}

}
