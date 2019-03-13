package leetcodePractice;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray34 {
	//�ҵĽⷨ���ȶ��ֲ����ҵ���һ�����ڵ�λ�ã�����ѭ���ҵ����һ�����ڵģ��㷨���Ӷ�Ϊ
	//O(logn)+O(k)������k��ֵȡ������ȵ�λ���Լ���ȵĸ������������˻�Ϊ
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
    
    //���߽ⷨ�����������ֲ��ҷֱ��ҵ���߽���ұ߽磬�㷨���Ӷ�ΪO(logn)
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
        int l = 0, h = nums.length; // ע�� h �ĳ�ʼֵ
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
