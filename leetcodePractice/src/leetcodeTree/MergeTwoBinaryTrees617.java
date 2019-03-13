package leetcodeTree;

public class MergeTwoBinaryTrees617 {
	//我的解法
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	TreeNode tmp ;
        if(t1==null&&t2==null) return null;
        else if(t1==null) {
        	tmp = new TreeNode(t2.val);
            tmp.left = mergeTrees(null, t2.left);
            tmp.right = mergeTrees(null, t2.right);
        } 
        else if(t2==null) {
        	tmp =  new TreeNode(t1.val);
            tmp.left = mergeTrees(t1.left, null);
            tmp.right = mergeTrees(t1.right, null);
        } 
        else {
        	tmp = new TreeNode(t1.val+t2.val);
            tmp.left = mergeTrees(t1.left, t2.left);
            tmp.right = mergeTrees(t1.right, t2.right);
        } 
        return tmp;	
    }
    //作者解法
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        //t1和t2其中只要有一个为空，直接返回另一个节点以及该节点下面的所有节点
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
    
    public static void main(String[] args) {
    	MergeTwoBinaryTrees617 test = new MergeTwoBinaryTrees617();
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(5);
		
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);
		root2.left.right = new TreeNode(4);
		root2.right.right = new TreeNode(7);
		
		TreeNode root = test.mergeTrees(root1,root2);
		System.out.println();
	}
}
