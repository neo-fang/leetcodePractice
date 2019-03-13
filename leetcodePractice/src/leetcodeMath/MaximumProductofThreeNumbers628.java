package leetcodeMath;

import java.util.Arrays;

public class MaximumProductofThreeNumbers628 {
    public int maximumProduct(int[] nums) {
    	int n = nums.length;
        Arrays.sort(nums);
        int max1 = nums[n-1]*nums[n-2]*nums[n-3];
        int max2 = nums[0]*nums[1]*nums[n-1];
        return Math.max(max1, max2);
    }
    public static void main(String[] args) {
		MaximumProductofThreeNumbers628 test = new MaximumProductofThreeNumbers628();
		int[] nums = {1,2,-5,-3,3,4};
		System.out.println(test.maximumProduct(nums));
	}
}
