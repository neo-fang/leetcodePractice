package leetcodeTree;

public class PathSum112 {
	int curSum = 0;
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null) return false;
    	if(root.left==null&&root.right==null) return curSum+root.val == sum;
        curSum += root.val;
        if(hasPathSum(root.left, sum)||hasPathSum(root.right, sum)) {
        	return true;
        }
        curSum -= root.val;
        return false;
    }
    public static void main(String[] args) {
    	PathSum112 test = new PathSum112();
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(5);
		root1.right.left = new TreeNode(5);
		System.out.println(test.hasPathSum(null, 9));
	}
}
