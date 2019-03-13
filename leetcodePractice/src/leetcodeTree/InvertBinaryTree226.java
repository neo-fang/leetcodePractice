package leetcodeTree;

public class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        if(root!=null) {
        	swap(root);
        	invertTree(root.left);
        	invertTree(root.right);
        } 
        return root;
    }
    public void swap(TreeNode root) {
		if(root == null||(root.left==null&&root.right==null)) {
			return;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
	}
    public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-1);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(-2);
		root.left.right = new TreeNode(-3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(3);
		InvertBinaryTree226 test = new InvertBinaryTree226();
		test.invertTree(root);
		System.out.println();
	}
}
