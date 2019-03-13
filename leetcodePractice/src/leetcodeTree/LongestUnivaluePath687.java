package leetcodeTree;

public class LongestUnivaluePath687 {
//	int max = 0;
//    public int longestUnivaluePath(TreeNode root) {
//    	
//    }
//    
//    public int findMax(TreeNode root,int curMax) {
//        if(root==null) return 0;
//        int tmp = 0;
//        if(root.left==null&&root.right==null) {
//        	
//        }
//        if(root.left!=null&&root.left.val==root.val) tmp++;
//        if(root.right!=null&&root.right.val==root.val) tmp++;
//        return tmp + findMax(root.left) + findMax(root.right);
//	}
	private int path = 0;

	public int longestUnivaluePath(TreeNode root) {
	    dfs(root);
	    return path;
	}

	private int dfs(TreeNode root){
	    if (root == null) return 0;
	    int left = dfs(root.left);
	    int right = dfs(root.right);
	    int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
	    int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
	    path = Math.max(path, leftPath + rightPath);
	    return Math.max(leftPath, rightPath);//最长相同节点个数
	}
	
	public static void main(String[] args) {
		LongestUnivaluePath687 test = new LongestUnivaluePath687();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(3);
		root.left.right.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(test.longestUnivaluePath(root));
	}
}
