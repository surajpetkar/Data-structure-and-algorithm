package com.shree.sorting;

// Time Complexity = O(n^2)   Best=O(n^2)     Avg=O(n^2)           
// Space Complexity = O(1)
public class SelectionSort {

	public static void main(String[] args) {
		
		int[] arr = {9,4,6,7,2,8,1};
		for(int i=0;i<arr.length;i++)
		{
			int min = arr[i];
			int pos = i;
			for(int j=i;j<arr.length;j++)
			{
				if(arr[j]<min)
				{
					min = arr[j];
					pos = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[pos];
			arr[pos] = temp;
			System.out.print(arr[i]);
		}
	}

}
