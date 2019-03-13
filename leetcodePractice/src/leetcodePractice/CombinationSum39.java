package leetcodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> finalList = new ArrayList<>();
    	List<Integer> tmpList = new ArrayList<>();
    	Arrays.sort(candidates);
    	calculate(candidates, target, 0, finalList, tmpList);
    	return finalList;
    }
    public static void calculate(int[] candidates, int target,int candidateIndex,List<List<Integer>> finalList,List<Integer> tmpList) {
    	if(target == 0) {
    		finalList.add(new ArrayList<>(tmpList));//找到合适数列
			return;
		}
    	if(target<0||candidateIndex==candidates.length) return;

		for(int i=0;i<target/candidates[candidateIndex]+1;i++) {
			for(int j=1;j<=i;j++) {//i表示当前candidate即candidates[candidateIndex]加多少次
				tmpList.add(candidates[candidateIndex]);
			}
			calculate(candidates, target-candidates[candidateIndex]*i,candidateIndex+1, finalList, tmpList);
			for(int j=1;j<=i;j++) {//i表示curNum加多少次
				tmpList.remove(tmpList.size()-1);
			}
		}
	}
    public static void main(String[] args) {
    	int[] candidates = {2,3,5};
    	int target = 0;
    	System.out.println(combinationSum(candidates, target));
	}
}
/*
 * Example:
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 * */
