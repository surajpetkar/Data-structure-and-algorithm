package com.shree.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Binary Tree - A tree having atmost 2 childs 

public class BinaryTreeTraversals {

	static Scanner sc = null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Node root = createNode();
		//inOrder(root);
		System.out.println();
		//preOrder(root);
		System.out.println();
		//postOrder(root);
		System.out.println();
		levelOrder(root);
	}
// Creating Tree using Recursion
	static Node createNode() {
		System.out.println("Enter value :");
		int data = sc.nextInt();
		if(data == -1)	return null;
		Node node = new Node(data);
		System.out.println("Enter left value of :"+node.val);
		node.left = createNode();
		System.out.println("Enter right value of :"+node.val);
		node.right = createNode();
		return node;
	}
// InOrder using Recursion	
	static void inOrder(Node root) {
		if(root==null)	 return;
		inOrder(root.left);
		System.out.print(root.val+" ");
		inOrder(root.right);
	}
	// preOrder using Recursion
	static void preOrder(Node root) {
		if(root==null)	 return;
		System.out.print(root.val+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	// postOrder using Recursion
	static void postOrder(Node root) {
		if(root==null)	 return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val+" ");
	}
	// levelOrder traversal using Recursion
	static void levelOrder(Node root) {
		Queue queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node cur = (Node) queue.poll();
			System.out.print(cur.val+" ");
			if(cur.left!=null)
				queue.add(cur.left);
			if(cur.right!=null)
				queue.add(cur.right);
		}
	}
}

class Node{
	Node left, right;
	int val;
	
	Node(int val){
		this.val = val;
	}
}
