package com.sunbeam;

import java.util.Scanner;

class CircularQueue {
	int arr[];
	int front = -1;
	int rear = -1;
	int size;
	int count = 0;

	public CircularQueue(int size) {
		this.size = size;
		arr = new int[size];
	}

	public void push(int value) {
		rear = (rear + 1) % size;
		arr[rear] = value;
		count++;

	}

	public int pop() {
		front = (front + 1) % size;
		count--;
		return arr[front];
	}

	public int peek() {
		return arr[front];
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == size;
	}

}

public class Question2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of Queue: ");
		int csize = sc.nextInt();
		CircularQueue cq = new CircularQueue(csize);
		for (;;) {
			System.out.println("------------------------------");
			System.out.println("1.Push Element\n2.Pop Element\n3.Peek\n4.Exit");
			System.out.println("------------------------------");
			System.out.println("Enter your choice:");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:

				if (cq.isFull()) {
					System.out.println("Queue is full");
				} else {
					System.out.println("Enter value:");
					int value = sc.nextInt();
					cq.push(value);
				}

				break;
			case 2:
				if (cq.isEmpty()) {
					System.out.println("Queue is Empty");
				} else {
					int p = cq.pop();
					System.out.println("Poped Element is: " + p);
				}
				break;
			case 3:
				if (!cq.isEmpty()) {
					int peek = cq.peek();
					System.out.println("Element peeked: " + peek);
				} else {
					System.out.println("Queue is Empty");
				}
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong choice..");
				break;
			}
		}

	}

}
