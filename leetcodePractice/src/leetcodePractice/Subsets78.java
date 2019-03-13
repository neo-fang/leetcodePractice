package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> finalList = new ArrayList<>();
    	doSubsets(nums, 0, finalList, new ArrayList<>());
    	return finalList;
    }
    
    public static void doSubsets(int[] nums,int start,List<List<Integer>> finalList,List<Integer> tmpList) {
		finalList.add(new ArrayList<>(tmpList));
		
		for(int i=start;i<nums.length;i++) {
			tmpList.add(nums[i]);
			doSubsets(nums, i+1, finalList, tmpList);
			tmpList.remove(tmpList.size()-1);
		}
	}
    public static void main(String[] args) {
		int[] nums = {2,3,1};
		System.out.println(subsets(nums));
	}
}
