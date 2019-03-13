package leetcodeTree;

public class BalancedBinaryTree110 {
    boolean result = true;
	public boolean isBalanced(TreeNode root) {
		depth(root);
		return result;
    }
    public int depth(TreeNode root) {
    	if(root==null) return 0;
    	int l = depth(root.left);
    	int r = depth(root.right);
    	if(Math.abs(l-r)>1) result = false; 
    	return 1+Math.max(l, r);
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right.right.right = new TreeNode(4);
		BalancedBinaryTree110 test = new BalancedBinaryTree110();
		System.out.println(test.isBalanced(root));
	}
}
