package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceinBST530 {
	//解法1：先中序遍历，得到有序数组，然后一次遍历数组得到最小绝对差值
	List<Integer> nums = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.size()-1;i++) {
        	min = Math.min(min, Math.abs(nums.get(i)-nums.get(i+1)));
        }
        return min;
    }
    public void inorder(TreeNode root) {
		if(root==null) return;
		inorder(root.left);
		nums.add(root.val);
		inorder(root.right);
	}
    
    //解法2：直接在中序遍历的过程中计算得到最小绝对差值
    int min = Integer.MAX_VALUE;
    int curVal = Integer.MAX_VALUE;
    public int getMinimumDifference2(TreeNode root) {
    	findInInorder(root);
    	return min;
    }
    public void findInInorder(TreeNode root) {
		if(root==null) return;
		findInInorder(root.left);
		min = Math.min(min,Math.abs(curVal-root.val));
		curVal = root.val;
		findInInorder(root.right);
	}
    
}
