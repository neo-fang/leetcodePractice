package leetcodeMath;

import java.util.Arrays;

public class MajorityElement169 {
	//��������λ����Ȼ����λ��
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
