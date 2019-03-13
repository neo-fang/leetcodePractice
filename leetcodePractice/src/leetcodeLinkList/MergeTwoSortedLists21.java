package leetcodeLinkList;

public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head = new ListNode(-1);
        if(l1.val<l2.val) {
        	head.val = l1.val;
        	l1 = l1.next;
        } else {
        	head.val = l2.val;
        	l2 = l2.next;
        }
        ListNode cur = head;
        while(l1!=null&&l2!=null) {
        	if(l1.val<l2.val) {
        		cur.next = new ListNode(l1.val);
            	l1 = l1.next;
            } else {
            	cur.next = new ListNode(l2.val);
            	l2 = l2.next;
            }
        	cur = cur.next;
        }
        //将未拼接完的链表直接接到后面
        cur.next = l1!=null?l1:l2;
        return head;
    }
    /*
     * Input: 1->2->4, 1->3->4
	 *Output: 1->1->2->3->4->4
     * */
    public static void main(String[] args) {
		MergeTwoSortedLists21 test = new MergeTwoSortedLists21();
		int[] nums1 = {1,2,4};
		int[] nums2 = {2,3,4};
		ListNode l1 = LinkListFunction.createListFromArray(nums1);
		ListNode l2 = LinkListFunction.createListFromArray(nums2);
		ListNode head = test.mergeTwoLists(l1, l2); 
		LinkListFunction.printLinkList(head);
	}
}
