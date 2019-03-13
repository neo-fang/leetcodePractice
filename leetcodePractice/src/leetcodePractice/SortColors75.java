package leetcodePractice;

import java.util.Arrays;

public class SortColors75 {
	public static int[] partition(int[] arr, int l, int r, int p) {
		int less = l - 1;
		int more = r + 1;
		while (l < more) {
			if (arr[l] < p) {
				swap(arr, ++less, l++);
			} else if (arr[l] > p) {
				//���ϴ�Ԫ����p���ұ߽���ߵ�һ��������ʱ�����ڻ�����ǰλ�õ�ֵ��һ����pС��
				//������Ȼ��Ҫ��p�Ƚϣ�����l������
				swap(arr, --more, l);
			} else {
				l++;//�������ִ�����߽����һ��Ԫ��һ���ǵ���p����
			}
		}
		return new int[] { less + 1, more - 1 };
	}
	
	public static void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void sortColors(int[] nums) {
        partition(nums, 0, nums.length-1, 1);
    }
	public static void main(String[] args) {
		//int[] arr = {3,2,5,4,5,3,7,9,2};
		//int pivot = 5;
		int[] arr = {2,0,2,1,1,0};
		System.out.println(Arrays.toString(arr));
		//partition(arr,0,arr.length-1, pivot);
		sortColors(arr);
		System.out.println(Arrays.toString(arr));
	}
}
