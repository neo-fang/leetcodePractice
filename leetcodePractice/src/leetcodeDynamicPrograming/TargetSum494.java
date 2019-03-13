package leetcodeDynamicPrograming;

import java.util.ArrayList;
import java.util.List;

public class TargetSum494 {
	//我的解法DFS(超时)
	static int total = 0;
    public static int findTargetSumWays(int[] nums, int S) {
        isValid(nums, S, 0,0);
        return total;
    }
    public static void isValid(int[] nums,int target,int curIndex,int length) {
    	if(length==nums.length&&target == 0) {
    		total++;
    		return;
    	}
		if(curIndex==nums.length) return;
		for(int i=curIndex;i<nums.length;i++) {
			length++;
			isValid(nums, target-nums[i], i+1,length);//该元素前面为+号
			isValid(nums, target+nums[i], i+1,length);//该元素前面为-号
			length--;
		}
	}
    
    //作者解法
    public static int findTargetSumWays2(int[] nums, int S) {
        int sum = computeArraySum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[W];
    }

    private static int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
    
    public static void main(String[] args) {
		int[] nums = {1, 1,1, 1, 1};
		int S = 3;
		System.out.println(findTargetSumWays2(nums, S));
		//System.out.println(list);
	}
}
