package com.shree.trees;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BSTOperations {

	static Scanner sc = null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Node root = createBST();
		//System.out.println(searchNode(root, 10).val);
		insertNewNode(root, 10);
		insertNode(root, 11);
		inOrder(root);
		System.out.println("");
		System.out.println("Middle Node deleted :");
		deleteNode(root, 10);
		inOrder(root);
		System.out.println("Leaf Node Deleted :");
		deleteNode(root, 11);
		inOrder(root);
		System.out.println("Parent Node Deleted :");
		deleteNode(root, 7);
		inOrder(root);
		System.out.println(isBST(root));
		System.out.println("Floor Value :"+floorOfKey(root, 5)+"    Ceil Value :"+ceilOfKey(root, 5));
		HashSet<Integer> set = new HashSet<>();
		System.out.println(twoSum(root, 11, set));
	}
	static Node createBST() {
		System.out.println("Enter value :");
		int data = sc.nextInt();
		if(data == -1)	return null;
		Node node = new Node(data);
		System.out.println("Enter left value of :"+node.val);
		node.left = createBST();
		System.out.println("Enter right value of :"+node.val);
		node.right = createBST();
		return node;
	}
	//	SEARCH A Node in Binary Search Tree using Recusion
	static Node searchNode(Node root, int nodeVal) {
		if(root == null) return null;
		if(root.val == nodeVal)	return root;
		if(root.val>nodeVal)	searchNode(root.left, nodeVal);
		if(root.val<nodeVal)	searchNode(root.right, nodeVal);
		return root;
	}
	//	INSERT A Node in Binary Search Tree using Recusion
	// Time Complexity : O(h)    Space Complexity : O(h)
	static Node insertNewNode(Node root, int key) {
		if(root == null)	return new Node(key);
		if(root.val>key) 
			root.left = insertNewNode(root.left, key);
		else if(root.val<key) 
			root.right = insertNewNode(root.right, key);
		return root;
	}
	//	INSERT A Node in Binary Search Tree using Iteration
	// Using Iteration we can achieve O(1) SC
	// Time Complexity : O(h)    Space Complexity : O(1)
	static Node insertNode(Node root, int key) {
		Node newNode = new Node(key);
		Node curr = root;
		Node parent = null;
		
		while(curr != null) {
			parent = curr;
			if(curr.val > key)
				curr = curr.left;
			else
				curr = curr.right;
		}
		if(parent == null)
			parent = newNode;
		if(parent.val > key)
			parent.left = newNode;
		else
			parent.right = newNode;
		
		return root;
	}
	// DELETE A Node from BST using Recursion
	// 3 Conditions :-
	//		Delete Leaf Node
	//		Delete Parent with One Child Node
	//		Delete Parent with Two Child Nodes
	static Node deleteNode(Node root, int target) {
		if(root == null)	return null;
		if(root.val > target)
			root.left = deleteNode(root.left, target);
		else if(root.val < target)
			root.right = deleteNode(root.right, target);
		else {
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			root.val = minValueOfRightSubTree(root.right);
			root.right = deleteNode(root.right, root.val);
		}
		return root;
	}
	private static int minValueOfRightSubTree(Node node) {
		int minValue = 0;
		while(node != null) {
			node = node.left;
			minValue = node.val;
		}
		return minValue;
	}
	// Check wether the tree is BST or not using INORDER technique
	// Inorder of BST is sorted Array
	static Node prev = null;
	static boolean isBST(Node root) {
		if(root != null) {
			if(!isBST(root.left))
				return false;
			if(prev != null && root.val <= prev.val)
				return false;
			prev = root;
			return isBST(root.right);
		}
		return true;
	}
	// Finding the FLOOR value of given Key 
	// Floor Value -> Immediate small value of key
	static int floorOfKey(Node root, int key) {
		int ans = Integer.MAX_VALUE;
		while(root != null) {
			if(root.val == key)
				return root.val;
			if(root.val > key)
				root = root.left;
			else {
				ans = root.val;
				root = root.right;
			}	
		}
		return ans;
	}
	// Finding the CEIL value of given Key 
	// Ceil Value -> Immediate Big value of key
	static int ceilOfKey(Node root, int key) {
		int ans = Integer.MIN_VALUE;
		while(root != null) {
			if(root.val == key)
				return root.val;
			if(root.val > key) {
				ans = root.val;
				root = root.left;
			}
			else 
				root = root.right;
		}
		return ans;
	}
	// Two Sum Problem in BST
	// Given is SUM of two values, we need to return true if addition of two node values in BST is == Sum else false   
	static boolean twoSum(Node root, int sum, HashSet set) {
		if(root == null)	return false;
		if(twoSum(root.left, sum, set))	return true;
		if(set.contains(sum-root.val))	return true;
		set.add(root.val);
		return twoSum(root.right, sum, set);
	}
	static void inOrder(Node root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.print(root.val+" ");
		inOrder(root.right);
	}
}
