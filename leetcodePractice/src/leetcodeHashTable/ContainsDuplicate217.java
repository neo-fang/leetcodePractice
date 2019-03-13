package leetcodeHashTable;

import java.util.HashSet;

public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int tmp:nums) {
        	if(set.contains(tmp)) return true;
        	set.add(tmp);
        }
        return false;
    }
}
