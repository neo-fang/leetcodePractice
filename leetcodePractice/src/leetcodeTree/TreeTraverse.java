package leetcodeTree;

import java.util.LinkedList;
import java.util.Queue;

//二叉树三种遍历方法
public class TreeTraverse {
	//层序遍历（从上往下从左往右一层层遍历）
	public void inlevel(TreeNode root) {
		if(root==null) return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int cnt = queue.size();
			for(int i=0;i<cnt;i++) {
				TreeNode node = queue.poll();
				System.out.print(node.val+"->");
        		if(node.left!=null) queue.add(node.left);
        		if(node.right!=null) queue.add(node.right);
			}
		}
	}
	
	//先序遍历（中->左->右）
	public void preorder(TreeNode root) {
		if(root==null) return;
		System.out.print(root.val+"->");
		preorder(root.left);
		preorder(root.right);
	}
	
	//中序遍历（左->中->右）
	public void inorder(TreeNode root) {
		if(root==null) return;
		inorder(root.left);
		System.out.print(root.val+"->");
		inorder(root.right);
	}
	
	//后序遍历（左->右->中）
	public void postorder(TreeNode root) {
		if(root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.val+"->");
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		TreeTraverse test = new TreeTraverse();
		test.inlevel(root);
	}
}
