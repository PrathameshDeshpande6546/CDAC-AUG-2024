package com.sunbeam;

import java.util.Scanner;

class Stack {
	int arr[];
	int top = -1;

	public Stack(int size) {
		size = size;
		arr = new int[size];
	}

	public void push(int value) {
		top++;
		arr[top] = value;

	}

	public int pop() {
		int temp = arr[top];
		top--;
		return temp;

	}

	public int peek() {
		return arr[top];
	}

}

public class Question1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int size = arr.length;
		Stack s = new Stack(size);
		System.out.print("Array: ");
		for (int e : arr) {
			System.out.print(e + " ");
		}
		for (int i = 0; i < arr.length; i++) {
			s.push(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			int temp = s.pop();
			arr[i] = temp;
		}
		System.out.println();
		System.out.print("Reverse Array: ");
		for (int e : arr) {
			System.out.print(e + " ");
		}

	}

}
