package leetcodeHashTable;

import java.util.HashMap;

public class TwoSum1 {
	//作者解法
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
        	if(map.containsKey(target-nums[i])) return new int[] {i,map.get(target-nums[i])};
        	else map.put(nums[i], i);//不用担心相同值的下表会被覆盖，不影响结果
        }
        return null;
    }
}
