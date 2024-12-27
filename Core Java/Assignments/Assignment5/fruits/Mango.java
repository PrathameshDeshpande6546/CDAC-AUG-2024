package com.app.fruits;

import java.util.Scanner;

public class Mango extends Fruit {

	public Mango() {

	}

	public void accept(Scanner sc) {
		super.accept(sc);
	}

	public void display() {
		super.display();
	}

	@Override
	public String taste() {
		return "Sweet";

	}

}
