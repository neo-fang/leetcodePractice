package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceinBST530 {
	//�ⷨ1��������������õ��������飬Ȼ��һ�α�������õ���С���Բ�ֵ
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
    
    //�ⷨ2��ֱ������������Ĺ����м���õ���С���Բ�ֵ
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
