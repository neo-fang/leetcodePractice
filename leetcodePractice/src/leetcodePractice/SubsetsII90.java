package leetcodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> finalList = new ArrayList<>();
    	Arrays.sort(nums);
    	doSubsets(nums, 0, finalList, new ArrayList<>(),new boolean[nums.length]);
    	return finalList;
    }
    
    public static void doSubsets(int[] nums,int start,List<List<Integer>> finalList,List<Integer> tmpList,boolean[] visited) {
		finalList.add(new ArrayList<>(tmpList));
		for(int i=start;i<nums.length;i++) {
			if(i!=0&&nums[i]==nums[i-1]&&!visited[i-1]) continue;
			tmpList.add(nums[i]);
			visited[i] = true;
			doSubsets(nums, i+1, finalList, tmpList,visited);
			visited[i] = false;
			tmpList.remove(tmpList.size()-1);
		}
    }
    public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		System.out.println(subsetsWithDup(nums));
	}
}
