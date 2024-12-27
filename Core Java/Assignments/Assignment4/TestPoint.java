package com.app.tester;

import com.app.geometry.Point2D;

public class TestPoint {

	public static void main(String[] args) {
		Point2D p1=new Point2D();
		Point2D p2=new Point2D();
		System.out.println("Point 1");
		p1.acceptPoints();
		System.out.println("Point 2");
		p2.acceptPoints();
		System.out.println(p1.getDetails());
		System.out.println(p2.getDetails());
		if(p1.isEqual(p2)) {
			System.out.println("Coordinates of p1 and p2 are equal");
		System.out.println(p1.isEqual(p2));
		}
		else {
			System.out.println("Cordinates of p1 and p2 are not equal");
			double distance=p1.calculateDistance(p2);
			System.out.println("Distance ="+distance);
		}
		
		
		
		
		
	}

	
}
