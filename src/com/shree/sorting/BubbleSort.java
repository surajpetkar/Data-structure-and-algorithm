package com.shree.sorting;

// Time Complexity = O(n^2)  Best=O(n) Avg=O(n^2)      
// Space Complexity = O(1)
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {5,3,1,9,2,7};
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]<arr[i])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.print(arr[i]);
		}
	}

}
