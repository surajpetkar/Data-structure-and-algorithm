package com.shree.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class BinaryTreeViews {
	
	static Scanner sc = null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Node root = createTree();
		bottomViewOfBinaryTree(root);
	}
	// creating binary tree 
	private static Node createTree() {
		System.out.println("Enter value :");
		int data = sc.nextInt();
		if(data == -1)	return null;
		Node root = new Node(data);
		System.out.println("Enter left node value of "+root.val);
		root.left = createTree();
		System.out.println("Enter right node value of "+root.val);
		root.right = createTree();
		return root;
	}
	
	private static void leftViewOfBinaryTree(Node root) {
		ArrayList<Node> list = new ArrayList<>();
		//leftViewOfBinaryTreeUtil(root, list, 0);
		rightViewOfBinaryTreeUtil(root, list, 0);
		for(Node n:list) {
			System.out.print(n.val+" ");
		}
	}
	// Actual Logic // Left view of BT using Recursion
	private static void leftViewOfBinaryTreeUtil(Node root, ArrayList list, int level) {
		if(root == null)	return;
		if(list.isEmpty() || list.size()==level)
			list.add(root);
		leftViewOfBinaryTreeUtil(root.left, list, level+1);
		leftViewOfBinaryTreeUtil(root.right, list, level+1);
	}
	// Actual Logic // Right view of BT using Recursion
	private static void rightViewOfBinaryTreeUtil(Node root, ArrayList list, int level) {
		if(root == null)	return;
		if(list.isEmpty() || list.size()==level)
			list.add(root);
		rightViewOfBinaryTreeUtil(root.right, list, level+1);
		rightViewOfBinaryTreeUtil(root.left, list, level+1);
	}
	// Top view of BT
	// Level Order Traversal -> need to use Queue
	private static void topViewOfBinaryTree(Node root) {
		Queue<Pair> queue = new ArrayDeque<>();
		Map<Integer, Integer> map = new TreeMap<>();
		queue.add(new Pair(0, root));
		while(!queue.isEmpty()) {
			Pair cur = queue.poll();
			if(!map.containsKey(cur.hd)) 
				map.put(cur.hd, cur.node.val);
			if(cur.node.left != null)
				queue.add(new Pair(cur.hd-1, cur.node.left));
			if(cur.node.right != null)
				queue.add(new Pair(cur.hd+1, cur.node.right));
		}
		for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
			System.out.print(entry.getValue()+" ");
		}
	}
	// Bottom view of BT
	// Level Order Traversal -> need to use Queue
	private static void bottomViewOfBinaryTree(Node root) {
		Queue<Pair> queue = new ArrayDeque<>();
		Map<Integer, Integer> map = new TreeMap<>();
		queue.add(new Pair(0, root));
		while(!queue.isEmpty()) {
			Pair cur = queue.poll();
			// just need to remove this condition
			map.put(cur.hd, cur.node.val);
			if(cur.node.left != null)
				queue.add(new Pair(cur.hd-1, cur.node.left));
			if(cur.node.right != null)
				queue.add(new Pair(cur.hd+1, cur.node.right));
		}
		for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
			System.out.print(entry.getValue()+" ");
		}
	}	
}

class Pair{
	int hd;
	Node node;
	public Pair(int hd, Node node) {
		this.hd = hd;
		this.node = node;
	}
}
