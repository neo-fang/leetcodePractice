package leetcodeTree;

public class LowestCommonAncestorofaBinarySearchTree235 {
	//�ҵĽⷨ�������Ŀ��˼������
	TreeNode commonFather;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.left==q||p.right==q) return p;
        if(q.left==p||q.right==p) return q;
        traversal(root, p, q);
        return commonFather;
    }
    public void traversal(TreeNode root,TreeNode p,TreeNode q) {
		if(root==null) return;
		if(root.left==p&&root.right==q||root.left==q&&root.right==p)
			commonFather = root;
		traversal(root.left,p,q);
		traversal(root.right,p,q);
	}

    //�������߽ⷨ
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    	if(root.val>p.val&&root.val>q.val) return lowestCommonAncestor2(root.left, p, q);
    	if(root.val<p.val&&root.val<q.val) return lowestCommonAncestor2(root.right, p, q);
    	return root;//p��q�ֱ������������л�������p��q��һ����ֱ�ӷ���
    }
    
}
