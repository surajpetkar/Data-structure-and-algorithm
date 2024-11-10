package com.shree.sorting;

// Time Complexity = O(n^2)    Best=O(n)   Avg=O(n^2)         
// Space Complexity = O(1)
public class InsertionSort {

	public static void main(String[] args) {

		int[] arr = {8,1,4,2,0,4,6,3};
		int current=0;
		for(int i=1;i<arr.length;i++)
		{
			int j = i-1;
			current = arr[i];
			while(j>=0 && arr[j]>current)
			{
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = current;
		}
		for(int i=0;i<arr.length;i++) {
		System.out.print(arr[i]);
		}
	}

}
