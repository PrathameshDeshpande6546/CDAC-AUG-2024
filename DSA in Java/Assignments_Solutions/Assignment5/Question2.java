package com.sunbeam;

class BinarySearchTree {
	static class Node {
		int data;
		Node left, right;

		public Node(int value) {
			this.data = value;
			left = right = null;
		}

	}

	Node root;

	public BinarySearchTree() {
		root = null;
	}

	private void preOrder(Node trav) {
		if (trav == null) {
			return;
		}
		System.out.print(" " + trav.data);
		preOrder(trav.left);
		preOrder(trav.right);

	}

	public void preOrder() {
		System.out.print("PreOrder: ");
		preOrder(root);
		System.out.println();

	}

	public void addNode(Node trav, int value) {
		Node newnode = new Node(value);
		if (root == null) {
			root = newnode;
		} else {

			if (value < trav.data) {
				if (trav.left == null) {
					trav.left = newnode;
					return;
				} else {
					addNode(trav.left, value);
				}
			} else {
				if (trav.right == null) {
					trav.right = newnode;
					return;
				} else {
					addNode(trav.right, value);
				}
			}

		}
	}

	public boolean binarySearch(Node trav, int key) {
		if (trav == null) {
			return false;
		}
		if (trav.data == key) {
			return true;
		} else {
			return binarySearch(trav.left, key) || binarySearch(trav.right, key);
		}

	}

}

public class Question2 {
	public static void main(String[] args) {
		BST bt = new BST();
		bt.addNode(bt.root, 50);
		bt.addNode(bt.root, 70);
		bt.addNode(bt.root, 90);
		bt.addNode(bt.root, 80);
		bt.addNode(bt.root, 40);
		bt.addNode(bt.root, 30);

		bt.preOrder();
		bt.binarySearch(bt.root, 80);
	}

}
