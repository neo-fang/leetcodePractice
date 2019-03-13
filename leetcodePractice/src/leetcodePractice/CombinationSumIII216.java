package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
    	List<List<Integer>> finalList = new ArrayList<>();
    	List<Integer> tmpList = new ArrayList<>();
    	doCombine(k, n, 1, finalList, tmpList);
    	return finalList;
    }
    
    public static void doCombine(int k,int target,int start,List<List<Integer>> finalList,List<Integer> tmpList) {
    	if(k==0&&target==0) {
    		finalList.add(new ArrayList<>(tmpList));
    		return;
    	}
    	if(k==0||target==0) return;
    	for(int i=start;i<=9;i++) {
    		tmpList.add(i);
    		doCombine(k-1, target-i, i+1, finalList, tmpList);
    		tmpList.remove(tmpList.size()-1);
    	}
    }
    public static void main(String[] args) {
    	int k = 3;
    	int n = 9;
    	System.out.println(combinationSum3(k, n));
	}
}
