package leetcodeTree;

public class LowestCommonAncestorofaBinaryTree236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val==p.val||root.val==q.val) return root;
        int num = numInATree(root.left, p.val, q.val);
        if(num==0) return lowestCommonAncestor(root.right, p, q);
        if(num==2) return lowestCommonAncestor(root.left, p, q);
        return root;
    }

    public int numInATree(TreeNode root,int p,int q) {
    	if(root == null) return 0;
    	if(root.val == p||root.val == q) return 1+numInATree(root.left, p, q)+numInATree(root.right, p, q);
    	return numInATree(root.left, p, q) + numInATree(root.right, p, q);
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		LowestCommonAncestorofaBinaryTree236 test = new LowestCommonAncestorofaBinaryTree236();
		System.out.println(test.lowestCommonAncestor(root,new TreeNode(4),new TreeNode(6)).val);

	}
}
