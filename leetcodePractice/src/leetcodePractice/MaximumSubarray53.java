package leetcodePractice;

public class MaximumSubarray53 {
	//���߽ⷨ��������⣩
	public int maxSubArray(int[] nums) {
	    if (nums == null || nums.length == 0) {
	        return 0;
	    }
	    int preSum = nums[0];
	    int maxSum = preSum;
	    for (int i = 1; i < nums.length; i++) {
	        preSum = preSum > 0 ? preSum + nums[i] : nums[i];
	        maxSum = Math.max(maxSum, preSum);
	    }
	    return maxSum;
	}
	
	//��Ʊ�ⷨ(�����߽ⷨһ��)
	/*
	 public int maxSubArray(int[] nums) {
	        if(nums.length == 0) {
	            return 0;
	        }
	        int curMax = nums[0];
	        int allMax = nums[0];
	        for(int i = 1; i < nums.length; i++) {
	            curMax = Math.max(nums[i], curMax + nums[i]);
	            allMax = Math.max(allMax, curMax);
	        }
	        return allMax;
	    }
	    */
}
