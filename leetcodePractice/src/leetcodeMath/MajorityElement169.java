package leetcodeMath;

import java.util.Arrays;

public class MajorityElement169 {
	//先排序，中位数必然是众位数
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
