package com.sunbeam;

import java.util.Scanner;

class LinearQueue {
	private int arr[];
	private int front, rear;
	private final int size;

	public LinearQueue(int size) {
		this.size = size;
		arr = new int[size];
		front = rear = 0;
	}

	public void push(int value) {
		arr[rear] = value;
		rear++;
	}

	public int pop() {
		int temp = arr[front];
		front++;
		return temp;
	}

	public int peek() {
		return arr[front];
	}

	public boolean isFull() {
		return rear == size;
	}

	public boolean isEmpty() {
		return front == rear;
	}

}

public class Question3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of queue");
		int size = sc.nextInt();
		LinearQueue q = new LinearQueue(size);
		for (;;) {
			System.out.println("1.Push Element\n2.Pop Element\n3.Peek\n4.Exit");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter value:");
				int value = sc.nextInt();
				if (q.isFull()) {
					System.out.println("Queue is full");
				} else {
					q.push(value);
				}

				break;
			case 2:
				if (q.isEmpty()) {
					System.out.println("Queue is Empty");
				} else {
					int p = q.pop();
					System.out.println("Poped Element is: " + p);

				}
				break;
			case 3:
				int peek = q.peek();
				System.out.println("Element peeked: " + peek);
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
