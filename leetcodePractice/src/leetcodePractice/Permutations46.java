package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
	
    public static List<List<Integer>> permute(int[] nums) {
    	int n = nums.length;
    	boolean[] isUsed = new boolean[n];
    	return makePermute(nums, isUsed, 0);
    }

    public static List<List<Integer>> makePermute(int[] nums,boolean[] isUsed,int time) {
    	List<List<Integer>> numList = new ArrayList<>();
    	if(time==nums.length-1) {
    		for(int i=0;i<nums.length;i++) {
    			if(!isUsed[i]) {
        			List<Integer> tmp = new ArrayList<>();
        			tmp.add(nums[i]);
        			numList.add(tmp);	
    			}
    		}
    		return numList;
    	}	
    	for(int i=0;i<nums.length;i++) {
    		if(!isUsed[i]) {
    			isUsed[i] = true;
    			for(List<Integer> tmpList:makePermute(nums, isUsed, time+1)) {
    				tmpList.add(nums[i]);
    				numList.add(tmpList);
    			}
    			isUsed[i] = false;//»ØËÝ
    		}
    	}
    	return numList;
	}
    public static void main(String[] args) {
    	int[] nums = {1,2,3,4};
    	System.out.println(permute(nums));
	}
    /*
     * Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
     * */
}
