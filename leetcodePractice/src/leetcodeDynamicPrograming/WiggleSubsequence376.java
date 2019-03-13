package leetcodeDynamicPrograming;

public class WiggleSubsequence376 {
	//高票解法1，https://leetcode.com/problems/wiggle-subsequence/solution/
	//解释：up[i]表示以i元素为上升沿且作为最后一个元素的最长摆动序列长度,同理，down[i]最后一个元素为下降沿的最长长度
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {//当前元素大于nums[j]时，则以当前元素为上升沿的最长序列长度为以元素j为下降沿的长度加1
                    up[i] = Math.max(up[i],down[j] + 1);
                } else if (nums[i] < nums[j]) {//同理，相等时保持不变
                    down[i] = Math.max(down[i],up[j] + 1);
                }
            }
        }
        return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
    }
    //高票解法2
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }
}
