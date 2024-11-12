package com.sunbeam;

public class BST {
	static class Node{
		private int data;
		private Node left, right;
		public Node(int value) {
			data = value;
			left = right = null;
		}
	}
	
	private Node root;
	public BST() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void addNode(int value) {
		//1. create node
		Node newnode = new Node(value);
		//2. if BST is empty
		if(root == null)
			root = newnode;
		//3. if BST is not empty
		else {
			//3.1 create trav and start at root
			Node trav = root;
			while(true) {
				//3.2 compare value with current node data
				if(value < trav.data) {
					//3.2.1 if value is less than current node data
					// if left of current node is empty
					if(trav.left == null) {
						// add newnode into left of current node
						trav.left = newnode;
						break;
					}else // if left of current node is not empty
						// go into left of current node
						trav = trav.left;
				}else {
					//3.2.2 if value is greater or equal to current node data
					// if right of current node is empty
					if(trav.right == null) {
						// add newnode into right of current node
						trav.right = newnode;
						break;
					}else// if right of current node is not empty
						// go into right of current node
						trav = trav.right;
				}
			}//3.3 repeat step 3.2 untill node is added in BST
		}
	}
	
	private void preOrder(Node trav) {
		//1. stop if left or right sub tree is absent
		if(trav == null)
			return;
		//2. print / visit current node
		System.out.print(" " + trav.data);
		//3. go in left current node
		preOrder(trav.left);
		//4. go in right of current node
		preOrder(trav.right);
	}
	
	public void preOrder() {
		System.out.print("Preorder : ");	
		preOrder(root);
		System.out.println();
	}
	
	private void inOrder(Node trav) {
		//1. stop if left or right sub tree is absent
		if(trav == null)
			return;
		//3. go in left current node
		inOrder(trav.left);
		//2. print / visit current node
		System.out.print(" " + trav.data);
		//4. go in right of current node
		inOrder(trav.right);
	}
	
	public void inOrder() {
		System.out.print("Inorder : ");	
		inOrder(root);
		System.out.println();
	}
	
	private void postOrder(Node trav) {
		//1. stop if left or right sub tree is absent
		if(trav == null)
			return;
		//3. go in left current node
		postOrder(trav.left);
		//4. go in right of current node
		postOrder(trav.right);
		//2. print / visit current node
		System.out.print(" " + trav.data);
	}
	
	public void postOrder() {
		System.out.print("Postorder : ");	
		postOrder(root);
		System.out.println();
	}
	
	public Node binarySearch(int key) {
		//1. start from root
		Node trav = root;
		while(trav != null) {
			//2. if key is equal to current node data then return current node address
			if(key == trav.data)
				return trav;
			//3. if key is less than current node data then serach key into left sub tree
			else if(key < trav.data)
				trav = trav.left;
			//4. if key is greater or equal than current node data then serach key into right sub tree
			else
				trav = trav.right;
		}//5. repeat above 3 steps till key is not found
		//6. if key is not found then return null
		return null;
	}
	
	public void deleteAll() {
		root = null;
	}
}













