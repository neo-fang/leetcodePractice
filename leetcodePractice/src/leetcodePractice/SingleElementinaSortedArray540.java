package leetcodePractice;

public class SingleElementinaSortedArray540 {
	//这种解决方法没有实现O(logn)的时间复杂度,空间复杂度O(1)，不满足要求
	/*
    public static int singleNonDuplicate(int[] nums) {
        for(int i = 0;i<nums.length-1;) {
        	if(nums[i] == nums[i+1]) {
        		i = i + 2;
        	}else {
        		return nums[i];
        	}
        }
        return nums[nums.length-1];
    }
    */
	//由于要求O(logn)的时间复杂度，因此必然需要对区间不断进行二分，类似于二分查找
	public static int singleNonDuplicate(int[] nums) {
		int l = 0;
		int r = nums.length-1;
		int m = (l+r)/2;
		while(l<r) {
			m = (l+r)/2;
			if(nums[m]==nums[m-1]) {
				if((m-l+1)%2==0) {
					l = m + 1;
				}else {
					r = m - 2;
				}
				continue;
			}
			if(nums[m] == nums[m+1]) {
				if((r-m+1)%2==0) {
					r = m - 1;
				}else {
					l = m + 2;
				}
				continue;
			}
		}
		return nums[l];
	}
    public static void main(String[] args) {
    	int[] nums = {1,1,2,2,3,3,4,4};
    	System.out.println(singleNonDuplicate(nums));
	}
}
