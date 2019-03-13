package leetcodeTree;

public class DiameterofBinaryTree543 {
	//左子树最大长度+右子树最大长度=最长直径，对每个节点递归比较直径，得到最大直径
    public int diameterOfBinaryTree(TreeNode root) {
    	if(root==null) return 0;
        int tmp = length(root.left) + length(root.right);
        tmp = Math.max(tmp, Math.max(diameterOfBinaryTree(root.left), 
        		diameterOfBinaryTree(root.right)));
        return tmp;
    }
    public int length(TreeNode root) {
		if(root == null) return 0;
		return 1+Math.max(length(root.left), length(root.right));
	}
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right.right.right = new TreeNode(4);
		DiameterofBinaryTree543 test = new DiameterofBinaryTree543();
		System.out.println(test.diameterOfBinaryTree(root));
	}
}
