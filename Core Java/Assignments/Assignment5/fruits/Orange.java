package com.app.fruits;

import java.util.Scanner;

public class Orange extends Fruit {

	public Orange() {

	}

	public void acccept(Scanner sc) {
		super.accept(sc);
	}

	public void display() {
		super.display();
	}

	@Override
	public String taste() {
		return "Sour";
	}

}
