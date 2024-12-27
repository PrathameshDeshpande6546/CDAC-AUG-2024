package com.app.geometry;

import java.util.Scanner;

public class Point2D {
	int x;
	int y;

	public Point2D() {
		x = 0;
		y = 0;
	}

	public Point2D(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDetails() {
		String details = "(X,Y) :" + "(" + x + "," + y + ")";
		return details;
	}

	public boolean isEqual(Point2D p2) {
		boolean check = false;
		if ((this.x == p2.x) && (this.y == p2.y)) {
			check = true;
		} else {
			calculateDistance(this);
		}
		return check;
	}

	public double calculateDistance(Point2D p2) {
		double distance = 0.0;
		distance = Math.sqrt(Math.pow(p2.x - this.x, 2) + Math.pow(p2.y - this.y, 2));
		return distance;

	}

	public void acceptPoints() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter x coordinate");
		setX(sc.nextInt());
		System.out.println("Enter y coordinate");
		setY(sc.nextInt());

	}

}
