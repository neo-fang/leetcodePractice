package leetcodePractice;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray34 {
	//我的解法：先二分查找找到第一个等于的位置，在用循环找到最后一个等于的，算法复杂度为
	//O(logn)+O(k)，其中k的值取决于相等的位置以及相等的个数，最坏情况下退化为
	//O(logn)+O(n)
    public static int[] searchRange(int[] nums, int target) {
    	if(nums == null||nums.length == 0) return new int[] {-1,-1};
        int l = 0;
        int r = nums.length - 1;
        int m = l + (r - l)/2;
        while(l<r) {
        	if(target <= nums[m]) {
        		r = m ;
        	}else {
        		l = m + 1;
        	}
        	m = l + (r-l)/2;
        }
        if(nums[l] == target) {
        	if(l == nums.length-1) return new int[] {l,l};
        	int right = l;
        	while(right<nums.length&&nums[right]==target) right++;
        	return new int[] {l,right-1};
        }else {
        	return new int[] {-1,-1};
        }
    }
    
    //作者解法：用两个二分查找分别找到左边界和右边界，算法复杂度为O(logn)
    public static int[] searchRange2(int[] nums, int target) {
        int first = binarySearch(nums, target);
        int last = binarySearch(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first,  last};
            //return new int[]{first, Math.max(first, last)};
        }
    }

    private static int binarySearch(int[] nums, int target) {
        int l = 0, h = nums.length; // 注意 h 的初始值
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    
    public static void main(String[] args) {
		int[] nums = {5};
		int target = 4;
		System.out.println(binarySearch(nums, target+1));
		System.out.println(Arrays.toString(searchRange2(nums, target)));
	}
}
