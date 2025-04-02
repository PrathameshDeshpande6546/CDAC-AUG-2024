package com.sunbeam.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.CustomerDao;
import com.sunbeam.dao.CustomerDaoImpl;
import com.sunbeam.dao.ItemDao;
import com.sunbeam.dao.ItemDaoImpl;
import com.sunbeam.entity.Items;

public class MainApp {
	
	public static int customermenu(Scanner sc) {
		System.out.println("---------------------------------------------------");
		System.out.println("1.View VegPizza");
		System.out.println("2.Show Non-Veg Items");
		System.out.println("3. Show available sizes (for given Item id)");
		System.out.println("--------------------------------------------------");
		System.out.println("Enter your choice");
		int ch=sc.nextInt();
		return ch;
	}
	
	private static void vegPizza() {
		try(ItemDao idoa=new ItemDaoImpl()) {
			String type="Veg";
			List<Items> i=idoa.showVegItems(type);
			i.forEach(System.out::println);
					
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	private static void nonVegPizza() {
		try(ItemDao idoa=new ItemDaoImpl()) {
			String type="NonVeg";
			List<Items> i=idoa.showNonVegItems(type);
			i.forEach(System.out::println);
					
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice;
		while((choice=customermenu(sc))!=0) {
			
			switch(choice) {
			case 1: vegPizza();
				break;
			case 2:nonVegPizza();
				
				break;

			default:System.out.println("Wrong choice");
				break;
			}
	}
		}

}
