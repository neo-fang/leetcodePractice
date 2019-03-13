package SearchPractice;

public class BinarySearch {
	//��������������������ҵ�һ��ƥ��λ��
	public static int binarySearch(int[] nums, int key) {
		int left = 0;
		int right = nums.length-1;
		int middle = (left + right)/2;
		while(left<=right) {
			if(key == nums[middle]) return middle;
			else if(key<nums[middle]) {
				right = middle-1;
			}else {
				left = middle + 1;	
			}
			middle =  (left + right)/2;
		}
		return -1;
	}
	//�����ظ����ֵ����������ߵ�ƥ��λ��
	public static int binarySearch2(int[] nums, int key) {
	    int l = 0, h = nums.length - 1;
	    while (l < h) {
	        int m = l + (h - l) / 2;
	        if (nums[m] >= key) {
	            h = m;
	        } else {
	            l = m + 1;
	        }
	    }
	  return key==nums[l]?l:-1;
	    //return l;//���ص�һ�����ڵ�λ�û��ߵ�һ������key��λ��
	}
	 
	
	public static void main(String[] args) {
		int[] nums ={5,7,7,8,8,10};
		int key = 6;
		System.out.println(binarySearch2(nums, key));
	}
}
