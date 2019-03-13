package leetcodeLinkList;

public class RemoveDuplicatesfromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null) return head;
        ListNode cur = head;
        ListNode next = head.next;
        while(next!=null) {
        	if(cur.val == next.val) {
        		cur.next = next.next;
        		next = cur.next;
        	}else {
        		cur = next;
        		next = next.next;
        	}
        }
        return head;
    }
    public static void main(String[] args) {
		RemoveDuplicatesfromSortedList83 test = new RemoveDuplicatesfromSortedList83();
		ListNode head = LinkListFunction.createListByKeyboard();
		LinkListFunction.printLinkList(head);
		System.out.println();
		head = test.deleteDuplicates(head);
		LinkListFunction.printLinkList(head);
	}
}
