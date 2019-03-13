package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIVInputisaBST653 {
	//解法1：将二叉树中序遍历的值存入数组中，再采用双指针的方法寻找和
	List<Integer> nums = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int left = 0;
        int right = nums.size()-1;
        while(left<right) {
        	if(nums.get(left)+nums.get(right)<k) left++;
        	else if(nums.get(left)+nums.get(right)>k) right--;
        	else return true;
        }
        return false;
    }
    public void inorder(TreeNode root) {
		if(root==null) return;
		inorder(root.left);
		nums.add(root.val);
		inorder(root.right);
	}
}
