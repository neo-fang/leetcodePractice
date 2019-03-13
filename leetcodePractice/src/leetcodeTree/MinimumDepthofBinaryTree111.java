package leetcodeTree;

public class MinimumDepthofBinaryTree111 {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right); 
        if(left==0||right==0) return 1+Math.max(left,right);
        return 1 + Math.min(left,right);
    }
//    public int minDepth(TreeNode root) {
//    	if(root==null) return 0;
//    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
//		root.right = new TreeNode(1);
//		root.left.left = new TreeNode(2);
//		root.left.right = new TreeNode(3);
//		root.right.left = new TreeNode(3);
		//root.right.right = new TreeNode(2);
		MinimumDepthofBinaryTree111 test = new MinimumDepthofBinaryTree111();
		System.out.println(test.minDepth(root));
	}
}
