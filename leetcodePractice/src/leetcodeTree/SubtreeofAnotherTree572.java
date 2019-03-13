package leetcodeTree;

public class SubtreeofAnotherTree572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null) return false;
        return isEqualTree(s, t)||isSubtree(s.left, t)||isSubtree(s.right, t);
    }
    public boolean isEqualTree(TreeNode s, TreeNode t) {
		if(t==null&&s==null) return true;
		if(s==null||t==null) return false;
		if(s.val!=t.val) return false;
		return isEqualTree(s.left, t.left)&&isEqualTree(s.right, t.right);
	}
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		root.right.right.right = new TreeNode(1);
		//root.right.right.right.left = new TreeNode(2);
		TreeNode root1 = root;
		root1.left = new TreeNode(2);
		TreeNode root2 = root;
		root2.right = new TreeNode(1);
		root2.right.left = new TreeNode(2);
		SubtreeofAnotherTree572 test= new SubtreeofAnotherTree572();
		System.out.println(test.isSubtree(root2, root1));
	}
    
}
