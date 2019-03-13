package leetcodeTree;

public class ConvertSortedArraytoBinarySearchTree108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length-1);
    }
    public TreeNode buildBST(int[] nums,int l,int r) {
    	if(l>r) return null;
		if(l==r) return new TreeNode(nums[l]);
		int mid = (l+r)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildBST(nums, l, mid-1);
		root.right = buildBST(nums, mid+1, r);
		return root;
	}
    public static void main(String[] args) {
    	ConvertSortedArraytoBinarySearchTree108 test = new ConvertSortedArraytoBinarySearchTree108();
		int[] nums = {-10,-3,0,5,9};
		TreeNode root = test.sortedArrayToBST(nums);
		System.out.println();
	}
}
