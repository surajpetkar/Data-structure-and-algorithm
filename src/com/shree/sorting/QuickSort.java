package com.shree.sorting;

//Time Complexity = O(n^2)    Best=O(nlogn)   Avg=O(nlogn)         
//Space Complexity = O(1)
public class QuickSort {
	public static void main(String[] args) {
		int[] a = {4,7,2,6,1,2};
		quick(0, a.length, a);
		for(int ar: a)
			System.out.print(ar);
	}
	public static void quick(int f, int l, int[] a) {
		if(f < l) {
			int j = partition(f, l, a);
			quick(f , j, a);
			quick(j+1 , l-1, a);
		}
	}
	public static int partition(int f, int l, int[] a) {
		int pivot = a[f]; 
		int i=f, j=l;
		while(i<j) {
			do {
				i++;
			}while(a[i]<=pivot);
			do {
				j--;
			}while(a[j]>pivot);
			if(i<j)
				swap(i, j, a);
		}
		swap(f, j, a);
		return j;
	}
	
	private static void swap(int c, int b,  int[] a) {
		// TODO Auto-generated method stub
		int temp = a[c];
		a[c] = a[b];
		a[b] = temp;
	}
	
}
