package leetcodeTree;

import java.util.ArrayList;

import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
	//参考作者解法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tmpList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	if(node==null) continue;//允许加入null元素
        	tmpList.add(node.val);
        	stack.push(node.right);//先压栈右孩子，则先遍历左孩子
        	stack.push(node.left);
        	}
        return tmpList;
        }

    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		BinaryTreePreorderTraversal144 test = new BinaryTreePreorderTraversal144();
		System.out.println(test.preorderTraversal(root));
	}
}
