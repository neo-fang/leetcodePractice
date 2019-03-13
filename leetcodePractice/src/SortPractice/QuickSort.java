package SortPractice;

import java.util.Arrays;

public class QuickSort {
	public static  void quickSort(int[] arr,int left,int right) {
		if(arr == null || arr.length<2) return;
		if(left<right) {
			int curPlace = left;
			swap(arr, left,(int) Math.random() * (right - left + 1)+left);//将left换成数组中随机的数，那么partition过程中pivot即随机
			curPlace = partition(arr, left, right);
			quickSort(arr, left, curPlace);
			quickSort(arr, curPlace+1, right);
		}
	}
	
	public static int partition(int[] arr,int left,int right) {
		int pivot = arr[left];
		int pivotIndex = left;
		while(left<right) {
			while(left<right&&arr[right]>=pivot) right--;
			if(left<right) 	arr[left] = arr[right];
			while(left<right&&arr[left]<=pivot) left++;
			if(left<right)		arr[right] = arr[left];
		}
		arr[left] = pivot;
		pivotIndex = left;
		return pivotIndex;
	}
	
	public static void swap(int[] arr, int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] arr = {5,12,2,33,4,10,1,0};
		System.out.println(Arrays.toString(arr));
		//partition(arr, 0, arr.length-1);
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
