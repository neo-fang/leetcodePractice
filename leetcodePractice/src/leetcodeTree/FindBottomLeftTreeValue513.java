package leetcodeTree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int first = root.val;
        while(!queue.isEmpty()) {
        	int cnt = queue.size();
        	first = queue.peek().val;
        	for(int i=0;i<cnt;i++) {
        		TreeNode node = queue.poll();
        		if(node.left!=null) queue.add(node.left);
        		if(node.right!=null) queue.add(node.right);
        	}
        }
        return first;
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(3);
		FindBottomLeftTreeValue513 test = new FindBottomLeftTreeValue513();
		System.out.println(test.findBottomLeftValue(root));
	}
}
