package SortPractice;import java.util.Arrays;

import javax.swing.JLabel;

public class HeapSort {

	/**
	 * 函数功能：根据初始数组arr构建初始大根堆，依次遍历数组，将每个节点与其父亲节点比较大小，比
	 * 父亲节点大，则跟父亲节点互换；不要讲每个节点跟孩子节点相比较，因为每个父亲节点有两个孩子
	 * 节点，并且还需要判断数组越界问题，比较麻烦。
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static void createHeap(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			heapInsert(arr, i);
			}
	}
	/**
	 *函数功能：调整节点i所在的父亲节点链，使该节点链满足大根堆要求
	 */
	public static void heapInsert(int[] arr,int i) {
		while(arr[i]>arr[(i-1)/2]) {//节点i的父亲节点编号为(i-1)/2
			swap(arr, i, (i-1)/2);//不能只将该节点与直接父亲节点相比，因为该节点可能比其父亲的父亲还大，因此只比较一次不一定满足大根堆条件
			i = (i-1)/2;//将节点i与其父亲节点比较，直到比较到根部
		}
	}
	/**
	 * 函数功能：实现堆排序，过程为：
	 * 每次将数组头部与尾部交换，并且使得数组有效范围（调整范围）减去1，则每次会将最大值调到最后，并且再也无法对其进行修改
	 * 调换头尾后，重新进行堆调整，即把调换到头部的数值调整到堆的合适位置
	 */
	public static void heapAdjust(int[] arr) {
		if(arr == null) return ;
		createHeap(arr);
		int heapSize = arr.length-1;
		for(int i=0; i < arr.length;i++) {
			swap(arr, heapSize--, 0);
			heapify(arr, heapSize);
		}
	}
	
	/**
	 * 函数功能：在原有堆上改变一个元素后，对堆进行重新调整，因此若某个节点不需要跟左右孩子调整，则调整结束，因为后面的
	 * 堆已经满足大根堆了，无需重新调整。
	 * @param arr
	 * @param heapSize
	 */
	public static void heapify (int[] arr,int heapSize ) {
		int head = 0;
		int leftChild = 2*head + 1;
		int rightChild = leftChild + 1;
		int largerChild = head;
		while(leftChild <= heapSize) {
			largerChild = rightChild <= heapSize&&arr[rightChild]>arr[leftChild]? rightChild:leftChild;//左右孩子中最大的
			largerChild = arr[largerChild]>arr[head]?largerChild:head;
			if(largerChild==head)  break;
			swap(arr, largerChild, head);
			head = largerChild;
			leftChild = 2*head + 1;
			rightChild = leftChild + 1;
		}
	}
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] arr = {6,3,7,9,5,4,1,0,10,8};
		createHeap(arr);
		System.out.println(Arrays.toString(arr));
		heapAdjust(arr);
		System.out.println(Arrays.toString(arr));
	}
}
