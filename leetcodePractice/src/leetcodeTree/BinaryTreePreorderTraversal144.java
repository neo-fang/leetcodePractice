package leetcodeTree;

import java.util.ArrayList;

import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
	//�ο����߽ⷨ
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tmpList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	if(node==null) continue;//�������nullԪ��
        	tmpList.add(node.val);
        	stack.push(node.right);//��ѹջ�Һ��ӣ����ȱ�������
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
