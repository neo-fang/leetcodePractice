package leetcodeTree;

public class TrimaBinarySearchTree669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null) return null;
        if(root.val<L) {
        	root = root.right;
        	return trimBST(root, L, R);
        }else if(root.val>R) {
        	root = root.left;
        	return trimBST(root, L, R);
        }else {
        	root.left = trimBST(root.left, L, R);
        	root.right = trimBST(root.right, L, R);
        	return root;
        }
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(0);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(1);
		TrimaBinarySearchTree669 test = new TrimaBinarySearchTree669();
		test.trimBST(root, 1, 3);
		System.out.println();
    }
}
