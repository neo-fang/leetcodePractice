package leetcodeLinkList;

public class OddEvenLinkedList328 {
	//O(n)空间复杂度，O(1)时间复杂度
    public ListNode oddEvenList(ListNode head) {
    	if(head==null||head.next==null) return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode curNode = head;
        ListNode tmp = head;
        //while(curNode.next!=null&&curNode.next.next!=null) {
        while(curNode.next!=null) {
        	tmp = curNode.next;
        	curNode.next = curNode.next.next;
        	curNode = tmp;
        }
        while(oddHead.next!=null) {
        	oddHead = oddHead.next;
        }
        oddHead.next = evenHead;
        return head;
    }
    
    public static void main(String[] args) {
    	OddEvenLinkedList328 test = new OddEvenLinkedList328();
		int[] nodes = {1,2};
		ListNode head = LinkListFunction.createListFromArray(nodes);
		LinkListFunction.printLinkList(head);
		head = test.oddEvenList(head);
		LinkListFunction.printLinkList(head);
	}
}
