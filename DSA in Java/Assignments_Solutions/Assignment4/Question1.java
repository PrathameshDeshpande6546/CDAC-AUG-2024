package com.assignment;

class SinglyCircular {
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	int size = 0;

	Node tail = null;

	public boolean isEmpty() {
		return tail == null;
	}

	public void addLast(int value) {
		Node newnode = new Node(value);

		if (isEmpty()) {
			tail = newnode;
			tail.next = newnode;
		} else {

			newnode.next = tail.next;
			tail.next = newnode;
			tail = newnode;
		}
		size++;
	}

	public void addPos(int pos, int value) {
		Node newnode = new Node(value);
		if (isEmpty()) {
			tail = newnode;
		} else if (pos == 1) {
			addFirst(value);
			return;

		} else if (pos == size || pos > size) {
			addLast(value);
			return;

		} else {
			Node trav = tail.next;
			for (int i = 1; i < pos - 1; i++) {
				trav = trav.next;
			}
			newnode.next = trav.next;
			trav.next = newnode;
			size++;
		}
	}

	public void addFirst(int value) {
		Node newnode = new Node(value);
		if (isEmpty()) {
			tail = newnode;
			tail.next = newnode;
		} else {
			newnode.next = tail.next;
			tail.next = newnode;
		}
		size++;
	}

	public int size() {
		return size;
	}

	public void deleteFirst() {
		if (isEmpty()) {
			return;
		} else if (size == 1) {
			tail = null;
			size--;

		} else {
			tail.next = tail.next.next;
			size--;
		}
	}

	public void deleteLast() {
		if (isEmpty()) {
			return;
		} else {
			Node trav = tail.next;
			while (trav.next != tail) {
				trav = trav.next;
			}
			trav.next = trav.next.next;
			tail = trav;
		}
		size--;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("List is Empty");
		} else {
			Node trav = tail.next;
			do {
				System.out.print("-->" + trav.data);
				trav = trav.next;
			} while (trav != tail.next);
			System.out.println();
		}
	}

}

public class Question1 {
	public static void main(String[] args) {
		SinglyCircular slc = new SinglyCircular();
		slc.addFirst(20);
		slc.addFirst(90);
		slc.addFirst(80);
		slc.addLast(800);
		slc.addPos(2, 30);
		slc.addPos(8, 07);
		slc.addPos(5, 88);
		slc.addPos(1, 9);

		slc.deleteFirst();
		slc.deleteLast();
		System.out.print("Singly Circular Linked List: ");
		slc.display();
		System.out.println("Size: " + slc.size());
	}

}
