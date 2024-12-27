package com.sunbeam.entity;

import java.util.Scanner;

public class Invoice {
	
	
	String partNo;
	String partDesc;
	int quantity;
	double price;
	
	public Invoice(){
		partNo="0";
		partDesc=" ";
		quantity=1;
		price=0.0;
	}
	public Invoice(String partNo,String partDesc,int quantity,double price) {
		this.partNo=partNo;
		this.partDesc=partDesc;
		this.quantity=quantity;
		this.price=price;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getPartDesc() {
		return partDesc;
	}

	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;}
	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
	
		this.price = price;}
		
	
	public void accept() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter PartNo.");
		setPartNo(sc.next());
		System.out.println("Enter PartDesc.");
		setPartDesc(sc.next());
		System.out.println("Enter Quantity.");
		quantity=sc.nextInt();
		if(quantity<0) {
			setQuantity(0);
		}
		else {
			setQuantity(quantity);
		}
		System.out.println("Enter Price");
		price=sc.nextDouble();
		if(price<0) {
			setPrice(0.0);
		}
		else {
			setPrice(price);
		}
		
	}
	
	
	public double calAmount() {
		double total;
		total=quantity*price;
		
		return total;
	}


}

