package leetcodeTree;

public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        return equalTree(root, treeReverse(root));
    }
    //返回翻转树
    public TreeNode treeReverse(TreeNode root) {	
		if(root == null) return null;
		if(root.left==null&&root.right==null) return new TreeNode(root.val);
		TreeNode newTree = new TreeNode(root.val);
		newTree.left = treeReverse(root.right);
		newTree.right = treeReverse(root.left);
		return newTree;
	}
    //比较两棵树是否相等
    public boolean equalTree(TreeNode root1,TreeNode root2) {
		if(root1==null&&root2==null) return true;
		if(root1==null||root2==null) return false;
		if(root1.val!=root2.val) return false;
		return equalTree(root1.left,root2.left)&&equalTree(root1.right, root2.right);
	}
    public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(2);
		SymmetricTree101 test = new SymmetricTree101();
		TreeNode tmp = test.treeReverse(root);
		System.out.println(test.isSymmetric(root));
		System.out.println();
	}
}
