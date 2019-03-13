package leetcodeTree;

public class SumofLeftLeaves404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left==null) return sumOfLeftLeaves(root.right);
        else {
        	if(root.left.left==null&&root.left.right==null)//判断是否为叶子节点
        		return root.left.val + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        	else return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        } 
    }
    public static void main(String[] args) {
    	SumofLeftLeaves404 test = new SumofLeftLeaves404();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(test.sumOfLeftLeaves(root));
	}
}
