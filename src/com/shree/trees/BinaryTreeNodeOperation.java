package com.shree.trees;

import java.util.Scanner;

public class BinaryTreeNodeOperation {

	static Scanner sc = null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Node root = createNode();
		//System.out.println(treeHeight(root));
		//btToDll(root);
		//diameterOfBt(root);
		//System.out.println(ans);
		//System.out.println(lowestCommonAncestor(root, 7, 6).val);
		burnBinaryTreeByGivenNode(root, 1, new Depth(-1));
		System.out.println(res);
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
	// Count number of Nodes in a tree using Recursion
	static int countAllNodes(Node root) {
		if(root==null) 	return 0;
		return countAllNodes(root.left) + countAllNodes(root.right)+1;
	}
	// Count Min and Max Node value in a Tree using Recursion
	static int maxNodeVal(Node root) {
		if(root==null) 	return 0;
		return Math.max(root.val, Math.max(maxNodeVal(root.left), maxNodeVal(root.right)));
	}
	// Count height of a Tree using Recursion
	static int treeHeight(Node root) {
		if(root==null) 	return 0;
		return Math.max(treeHeight(root.left), treeHeight(root.right))+1;
	}
	// Convert BT to Doubly LinkedList
	// follows inorder
	static Node prev, head=null;
	static void btToDll(Node root) {
		if(root==null) 	return;
		btToDll(root.left);
		if(prev == null) head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		System.out.print(prev.val+" ");
		btToDll(root.right);
	}
	// Calculate Diameter of BT -> No. of nodes in the largest path of two leaf nodes
	// based on height calculation
	static int ans=0;
	static int diameterOfBt(Node root) {
		if(root == null) {
			return 0;
		}
		int lh = diameterOfBt(root.left);
		int rh = diameterOfBt(root.right);
		ans = Math.max(ans, 1+lh+rh);
		return Math.max(lh, rh) + 1;
	}
	// Lowest Common Ancestor of given nodes in BT
//  Conditions :  1} cur==a || cur==b
	//			  2} a -> left subtree and b -> right subtree 
	//		  	  3} both a and b in anyone subtree
	//			  4} none of a and b in anyone subtree
	static Node lowestCommonAncestor(Node root, int a, int b) {
		if(root == null) return null;
		if(root.val==a || root.val==b)	return root;
		Node left = lowestCommonAncestor(root.left, a, b);
		Node right = lowestCommonAncestor(root.right, a, b);
		if(left == null)	 return right;
		if(right == null)	 return left;
		return root;
	}
	// Minimum Time To Burn A BT Starting From The Leaf Node
	// Based on Height + Depth Calculation
	static int res = -1;
	static int burnBinaryTreeByGivenNode(Node root, int target, Depth depth) {
		if(root == null) return 0;
		if(root.val == target) {
			depth.d = 1;
			return 1;
		}
		Depth ld = new Depth(-1);
		Depth rd = new Depth(-1);
		
		int lh = burnBinaryTreeByGivenNode(root.left, target, ld);
		int rh = burnBinaryTreeByGivenNode(root.left, target, rd);
		
		if(ld.d != -1) {
			res = Math.max(res, ld.d+1+rd.d);
			depth.d = 1+ld.d;
		}
		else if(rd.d != -1) {
			res = Math.max(res, rd.d+1+ld.d);
			depth.d = 1+rd.d;
		}
		return Math.max(lh, rh) + 1;
	}
}

class Depth{
	int d;
	public Depth(int d){
		this.d = d;
	}
}
// class Node is define in BinaryTreeTraversal 