package leetcodeTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;   
    TreeNode(int x) { val = x; }
 }
public class MaximumDepthofBinaryTree104 {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		MaximumDepthofBinaryTree104 test = new MaximumDepthofBinaryTree104();
		System.out.println(test.maxDepth(root));
	}
}
