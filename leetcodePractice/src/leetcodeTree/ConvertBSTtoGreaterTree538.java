package leetcodeTree;

public class ConvertBSTtoGreaterTree538 {
	int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        inorder(root);
        return root;
    }
    public void inorder(TreeNode root) {
		if(root==null) return;
		inorder(root.right);
		int tmp = root.val;
		root.val += sum;
		sum += tmp;
		inorder(root.left);
	}
}
