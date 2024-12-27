package com.sunbeam.test;

import com.sunbeam.entity.Invoice;

public class InvoiceTest {
	public static void main(String[] args) {
		double totalBill=0.0;
		double r=0;
		Invoice i1=new Invoice();
		System.out.println("Enter Hardware info");
		i1.accept();
		r+=i1.calAmount();
		totalBill=totalBill+i1.calAmount();
		Invoice i2=new Invoice();
		System.out.println("Enter Hardware info");
		i2.accept();
		r+=i2.calAmount();
		totalBill+=i1.calAmount();
//		
		System.out.println("Part_No\t"+"PartDesc\t"+"Quantity\t"+"Price");
		
		System.out.println(i1.getPartNo()+"\t"+i1.getPartDesc()+"\t\t"+i1.getQuantity()+"\t"+i1.getPrice());
		System.out.println(i2.getPartNo()+"\t"+i2.getPartDesc()+"\t\t"+i2.getQuantity()+"\t"+i2.getPrice());
		
			System.out.println("Total Amount:"+ r);
	

	}

	}
