package leetcodeTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> tmpList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode tmp = stack.pop();
        	if(tmp==null) continue;
        	tmpList.add(tmp.val);
        	stack.push(tmp.left);
        	stack.push(tmp.right);
        }
        Collections.reverse(tmpList);
        return tmpList;
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		BinaryTreePostorderTraversal145 test = new BinaryTreePostorderTraversal145();
		System.out.println(test.postorderTraversal(root));
	}
}
