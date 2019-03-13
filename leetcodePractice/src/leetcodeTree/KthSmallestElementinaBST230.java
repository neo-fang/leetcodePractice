package leetcodeTree;

import java.util.ArrayList;

public class KthSmallestElementinaBST230 {
	//ArrayList<Integer> numList = new ArrayList<>();
	int cnt = 0;
	int res;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return res;
    }
    
    public void inorder(TreeNode root,int k) {
		if(root==null) return ;
		inorder(root.left,k);
		cnt++;
		if(cnt==k) res = root.val;
		inorder(root.right,k);
	}
}
