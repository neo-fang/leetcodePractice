package leetcodeTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> tmpList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return tmpList;
        TreeNode cur = root;
        while(cur!=null||!stack.isEmpty()) {
        	while(cur!=null) {
        		stack.push(cur);
        		cur = cur.left;
        	}
        	cur = stack.pop();
        	tmpList.add(cur.val);
        	cur = cur.right;
        }
//我的解法
//        stack.push(root);
//        while(!stack.isEmpty()) {
//        	while(root.left!=null) {
//        		stack.push(root.left);
//        		root = root.left;
//        	}
//        	TreeNode tmp = stack.pop();
//        	tmpList.add(tmp.val);
//        	if(tmp.right!=null) {
//        		root = tmp.right;
//        		stack.push(root);
//        	} 
//        }
       return tmpList;
   }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		BinaryTreeInorderTraversal94 test = new BinaryTreeInorderTraversal94();
		System.out.println(test.inorderTraversal(root));
	}
}
