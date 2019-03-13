package SortPractice;import java.util.Arrays;

import javax.swing.JLabel;

public class HeapSort {

	/**
	 * �������ܣ����ݳ�ʼ����arr������ʼ����ѣ����α������飬��ÿ���ڵ����丸�׽ڵ�Ƚϴ�С����
	 * ���׽ڵ��������׽ڵ㻥������Ҫ��ÿ���ڵ�����ӽڵ���Ƚϣ���Ϊÿ�����׽ڵ�����������
	 * �ڵ㣬���һ���Ҫ�ж�����Խ�����⣬�Ƚ��鷳��
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
	 *�������ܣ������ڵ�i���ڵĸ��׽ڵ�����ʹ�ýڵ�����������Ҫ��
	 */
	public static void heapInsert(int[] arr,int i) {
		while(arr[i]>arr[(i-1)/2]) {//�ڵ�i�ĸ��׽ڵ���Ϊ(i-1)/2
			swap(arr, i, (i-1)/2);//����ֻ���ýڵ���ֱ�Ӹ��׽ڵ���ȣ���Ϊ�ýڵ���ܱ��丸�׵ĸ��׻������ֻ�Ƚ�һ�β�һ��������������
			i = (i-1)/2;//���ڵ�i���丸�׽ڵ�Ƚϣ�ֱ���Ƚϵ�����
		}
	}
	/**
	 * �������ܣ�ʵ�ֶ����򣬹���Ϊ��
	 * ÿ�ν�����ͷ����β������������ʹ��������Ч��Χ��������Χ����ȥ1����ÿ�λὫ���ֵ������󣬲�����Ҳ�޷���������޸�
	 * ����ͷβ�����½��жѵ��������ѵ�����ͷ������ֵ�������ѵĺ���λ��
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
	 * �������ܣ���ԭ�ж��ϸı�һ��Ԫ�غ󣬶Զѽ������µ����������ĳ���ڵ㲻��Ҫ�����Һ��ӵ������������������Ϊ�����
	 * ���Ѿ����������ˣ��������µ�����
	 * @param arr
	 * @param heapSize
	 */
	public static void heapify (int[] arr,int heapSize ) {
		int head = 0;
		int leftChild = 2*head + 1;
		int rightChild = leftChild + 1;
		int largerChild = head;
		while(leftChild <= heapSize) {
			largerChild = rightChild <= heapSize&&arr[rightChild]>arr[leftChild]? rightChild:leftChild;//���Һ���������
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
