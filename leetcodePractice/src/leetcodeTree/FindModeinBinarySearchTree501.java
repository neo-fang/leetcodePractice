package leetcodeTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FindModeinBinarySearchTree501 {
	//解法1：中序遍历过程中用map统计每个元素出现次数，遍历map得到出现次数最多的一个或多个元素
	HashMap<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        List<Integer> maxList = new ArrayList<>();
        int max = 0;
        for(int cnt:map.values()) {
        	max = max<cnt?cnt:max;
        }
        for(int key:map.keySet()) {
        	if(map.get(key)==max) maxList.add(key);
        }
        int[] maxArray = new int[maxList.size()];
        for(int i=0;i<maxList.size();i++) {
        	maxArray[i] = maxList.get(i);
        }
        return maxArray;
    }
    public void inorder(TreeNode root) {
		if(root==null) return;
		inorder(root.left);
		map.put(root.val,map.getOrDefault(root.val, 0)+1);
		inorder(root.right);
	}
}
