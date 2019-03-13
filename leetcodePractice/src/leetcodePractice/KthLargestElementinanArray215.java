package leetcodePractice;

import java.util.PriorityQueue;

public class KthLargestElementinanArray215 {
	/**
	 * ���ֽⷨ����һ���ǲ��������㷨���Լ�ʵ�ֻ���ֱ�ӵ��ÿ⺯�����������������
	 * Ȼ�󷵻ص�k���Ԫ�أ�
	 * �ڶ��нⷨ����PriorityQueueʵ��С���ѣ�ά��С���ѵĴ�СΪk��������Ԫ�����
	 * ��ϣ�Ԫ�ظ�������kʱ��ɾ��һ����Ԫ�أ���ʣ�µĴ�СΪk�����ȼ�����ͷ����Ϊ��k��Ԫ��
	 * @param arr
	 * @param left
	 * @param right
	 */
	/*************************************��һ�ֽⷨ******************************/
	/*���ÿ�������ʵ������*/
	public static  void quickSort(int[] arr,int left,int right) {
		if(arr == null || arr.length<2) return;
		if(left<right) {
			int curPlace = left;
			swap(arr, left,(int) Math.random() * (right - left + 1)+left);//��left���������������������ôpartition������pivot�����
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
	/*Ѱ�ҵ�k�����*/
	public int findKthLargest1(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }
	
	/*************************************�ڶ��ֽⷨ******************************/
	public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int e : nums) {
        	priorityQueue.add(e);
        	if(priorityQueue.size()>k) priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
