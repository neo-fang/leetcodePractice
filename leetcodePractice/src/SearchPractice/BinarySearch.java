package SearchPractice;

public class BinarySearch {
	//随机在有序（增序）序列中找到一个匹配位置
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
	//若有重复相等值，返回最左边的匹配位置
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
	    //return l;//返回第一个等于的位置或者第一个大于key的位置
	}
	 
	
	public static void main(String[] args) {
		int[] nums ={5,7,7,8,8,10};
		int key = 6;
		System.out.println(binarySearch2(nums, key));
	}
}
