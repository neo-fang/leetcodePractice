package leetcodeLinkList;

public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
    	if(head==null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = cur.next;
        while(cur!=null) {
        	tmp = cur.next;
        	cur.next = pre;
        	pre = cur;
        	cur = tmp;
        }
        return pre;
    }
    public static void main(String[] args) {
		ReverseLinkedList206 test = new ReverseLinkedList206();
		ListNode head = LinkListFunction.createTestList();
		LinkListFunction.printLinkList(head);
		System.out.println();
		LinkListFunction.printLinkList(test.reverseList(head));
	}
}
