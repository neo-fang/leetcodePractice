package leetcodeHashTable;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence128 {
	//解法1：参考作者解法
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int tmp:nums) map.put(tmp, 1);//以每个元素tmp为连续串的开头的连续串长度
        for(int tmp:map.keySet()) {
        	map.put(tmp, findMaxConsecutive(map, tmp));
        }
        return max(map);
    }
    //函数功能：找到以curVal为连续串开头的连续串最大长度
    public int findMaxConsecutive(HashMap<Integer,Integer> map, int curVal) {
		if(!map.containsKey(curVal)) return 0;
		int cnt = map.get(curVal);
		if(cnt!=1) return cnt;
		return 1 + findMaxConsecutive(map, curVal+1);
	}
    //函数功能：找到最大连续串长度
    public int max(HashMap<Integer,Integer> map) {
		int max = 0;
		for(int key:map.keySet()) {
			max = Math.max(max, map.get(key));
		}
		return max;
	}
    //解法2：参考网上解法
    public int longestConsecutive2(int[] nums) {
    	HashSet< Integer> set = new HashSet<>();
    	int max = 0;
    	for(int tmp:nums) set.add(tmp);
    	for(int tmp:nums) {
    		if(!set.contains(tmp)) continue;
    		set.remove(tmp);
    		int first = tmp - 1;
    		int last = tmp + 1;
    		while(set.contains(first)) {set.remove(first);first--;}
    		while(set.contains(last))  {set.remove(last);last++;}
    		max = Math.max(last-first-1,max);
    	}
    	return max;
    }
    
    public static void main(String[] args) {
		int[] nums = {100, 4, 101, 1, 3, 2};
		LongestConsecutiveSequence128 test = new LongestConsecutiveSequence128();
		System.out.println(test.longestConsecutive2(nums));
	}
}
