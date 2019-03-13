package leetcodeDynamicPrograming;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence300 {
	//参照作者解法
    public static int lengthOfLIS(int[] nums) {
    	if(nums==null||nums.length==0) return 0;
    	int n = nums.length;
        int[] longest = new int[n];//longest[i]表示以元素i为终点的最大递增子序列长度
        longest[0] = 1;
        int finalLength = 1;
        for(int i=1;i<n;i++) {
        	int tmpLongest = 1;
        	for(int j=0;j<i;j++) {//比较当前元素与之前所有元素的大小，大于之前某个元素j，则将longest[j]+1		
        		if(nums[i]>nums[j]) {//只有大于的情况才能以元素i结尾
        			tmpLongest = tmpLongest>longest[j]+1?tmpLongest:longest[j]+1;
        		}
        	}
        	longest[i] = tmpLongest;
        	finalLength = Math.max(finalLength, tmpLongest);
        }
        return finalLength;
    }
    
    //参照作者解法的优化
    public static int lengthOfLIS2(int[] nums) {
        if (nums.length==0) return 0;
        List<Integer> ends = new ArrayList<>();
        ends.add(nums[0]);
        for (int a : nums) {
            if (a < ends.get(0)) ends.set(0, a) ;
            else if (a > ends.get(ends.size()-1)) ends.add(a);
            else {
                int left = 0, right = ends.size();
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (ends.get(mid) < a) left = mid + 1;
                    else right = mid;
                }
                ends.set(right, a) ;
            }
        }
        return ends.size();
    }
    
    public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS2(nums));
    }
}
