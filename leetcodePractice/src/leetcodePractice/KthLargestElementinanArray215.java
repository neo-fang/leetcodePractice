package leetcodePractice;

import java.util.PriorityQueue;

public class KthLargestElementinanArray215 {
	/**
	 * 两种解法：第一种是采用排序算法（自己实现或者直接调用库函数）对数组进行排序，
	 * 然后返回第k大的元素；
	 * 第二中解法：用PriorityQueue实现小根堆，维持小根堆的大小为k，当所有元素添加
	 * 完毕（元素个数超过k时，删除一个最元素），剩下的大小为k的优先级队列头部即为第k大元素
	 * @param arr
	 * @param left
	 * @param right
	 */
	/*************************************第一种解法******************************/
	/*先用快速排序实现排序*/
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
	/*寻找第k大的数*/
	public int findKthLargest1(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }
	
	/*************************************第二种解法******************************/
	public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int e : nums) {
        	priorityQueue.add(e);
        	if(priorityQueue.size()>k) priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
