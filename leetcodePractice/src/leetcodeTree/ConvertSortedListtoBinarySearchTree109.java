package leetcodeTree;

import java.util.ArrayList;
import java.util.List;
class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
}

public class ConvertSortedListtoBinarySearchTree109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nums = new ArrayList<Integer>();
        while(head!=null) {
        	nums.add(head.val);
        	head = head.next;
        }
        return buildBST(nums, 0, nums.size()-1);
    }
    public TreeNode buildBST(List<Integer> nums,int l,int r) {
    	if(l>r) return null;
		if(l==r) return new TreeNode(nums.get(l));
		int mid = (l+r)/2;
		TreeNode root = new TreeNode(nums.get(mid));
		root.left = buildBST(nums, l, mid-1);
		root.right = buildBST(nums, mid+1, r);
		return root;
	}
}
