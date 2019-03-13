package leetcodeTree;

public class PathSumIII437 {
	//以节点root开头的所有节点相加数值为sum的情况数量
    public int oneSum(TreeNode root, int sum) {
    	if(root==null) return 0;
        if(root.val==sum) {
        	return 1 + oneSum(root.left, 0)+oneSum(root.right, 0);
        }
        else return oneSum(root.left, sum-root.val) + oneSum(root.right, sum-root.val);
    }
    //以root树上每个节点为首节点，计算和为sum的可能情况数量和
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        int tmp = oneSum(root, sum);
        return tmp + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public static void main(String[] args) {
//		TreeNode root1 = new TreeNode(1);
//		root1.left = new TreeNode(-2);
//		root1.right = new TreeNode(-3);
//		root1.left.left = new TreeNode(1);
//		root1.left.right = new TreeNode(3);
//		root1.right.left = new TreeNode(-2);
//		root1.left.left.left = new TreeNode(-1);
    	TreeNode root1 = new TreeNode(0);
    	root1.left = new TreeNode(1);
    	root1.right = new TreeNode(1);
		PathSumIII437 test = new PathSumIII437();
		System.out.println(test.pathSum(root1, 0));
	}
}
