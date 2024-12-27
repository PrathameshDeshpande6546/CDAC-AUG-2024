package com.app.fruits;

import java.util.Scanner;

public class Apple extends Fruit {

	public Apple() {

	}

	public void accept(Scanner sc) {
		super.accept(sc);

	}

	public void display() {
		super.display();
	}

	@Override
	public String taste() {
		return "Sour and Sweet";

	}

}
