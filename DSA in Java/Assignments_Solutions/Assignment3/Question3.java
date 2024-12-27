package com.sunbeam;

import java.util.Scanner;

class List {
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	Node head;

	public List() {
		head = null;

	}

	public void addBeforeData(int newdata, int posData) {
		Node trav = head;
		Node ref = null;
		Node newNode = new Node(newdata);
		if (isEmpty()) {
			head = newNode;
		} else {
			while (trav.data != posData) {
				ref = trav;
				trav = trav.next;
			}
			if (ref != null) {
				newNode.next = trav;
				ref.next = newNode;
			} else if (ref == null && trav == head) {
				newNode.next = trav;
				head = newNode;
			} else {
				newNode.next = trav.next;
				trav.next = newNode;
			}

		}
	}

	public void addAfterData(int newdata, int posData) {
		Node trav = head;
		Node newNode = new Node(newdata);
		if (isEmpty()) {
			head = newNode;
		} else if (trav.next == null) {
			trav.next = newNode;
		} else {
			while (trav.data != posData) {
				trav = trav.next;
			}
			newNode.next = trav.next;
			trav.next = newNode;
		}
	}

	public void display() {
		Node trav = head;
		if (trav == null) {
			System.out.println("List is Empty..");
		} else {
			while (trav != null) {

				System.out.println(" " + trav.data);
				trav = trav.next;
			}
			System.out.println();
		}
	}

	public boolean isEmpty() {
		return head == null;

	}
}

public class Question3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List l1 = new List();
		for (;;) {
			System.out.println("---------------------------------------");
			System.out.println("0.Exit\n1.Add After given Data\n2.Add Before Given Data\n3.Display Linked List");
			System.out.println("---------------------------------------");
			System.out.println("Enter your choice:");
			int choice = sc.nextInt();
			switch (choice) {
			case 0:
				System.exit(0);
				break;
			case 1:
				System.out.println("Enter New Data");
				int d = sc.nextInt();
				System.out.println("Enter given data to add new data After it");
				int gd = sc.nextInt();
				l1.addAfterData(d, gd);
				break;
			case 2:
				System.out.println("Enter New Data");
				int d1 = sc.nextInt();
				System.out.println("Enter given data to add new data Before it");
				int gd1 = sc.nextInt();
				l1.addBeforeData(d1, gd1);
				break;
			case 3:
				System.out.println("Linked List");
				l1.display();

				break;

			default:
				System.out.println("Worng choice...");
				break;
			}
		}

	}

}
