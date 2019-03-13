package leetcodeTree;

public class SecondMinimumNodeInaBinaryTree671 {
	//我的解法，错误
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        if(root.left==null&&root.right==null) return -1;//该节点有0个子节点
        if(root.left.val!=root.right.val) return Math.max(root.left.val, root.right.val);
        else {
        	int left = findSecondMinimumValue(root.left);
        	int right = findSecondMinimumValue(root.right);
        	if(left!=-1&&right!=-1) return Math.min(left, right);
        	return Math.max(left,right);
		}
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(2);
		root.left.left.left = new TreeNode(2);
		root.left.left.right = new TreeNode(3);
		SecondMinimumNodeInaBinaryTree671 test = new SecondMinimumNodeInaBinaryTree671();
		System.out.println(test.findSecondMinimumValue(root));
	}
}
