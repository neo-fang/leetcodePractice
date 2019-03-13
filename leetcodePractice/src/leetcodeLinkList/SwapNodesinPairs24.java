package leetcodeLinkList;

public class SwapNodesinPairs24 {
    public ListNode swapPairs(ListNode head) {
    	if(head==null||head.next==null) return head;
        ListNode cur = head;
        ListNode next = head.next;
        ListNode pre = null;
        head = next;
        cur.next = next.next;
        next.next = cur;     
        pre = cur;
        cur = cur.next;
        if(cur==null) return head;
        next = cur.next;
        while(cur!=null&&next!=null) {
        	//�������ڽڵ�λ��
        	cur.next = next.next;
        	next.next = cur;
        	pre.next = next;	
        	//�ƶ�����һ�ڵ�
        	pre = cur;
        	cur = cur.next;
        	if(cur==null) return head;
        	next = cur.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
		SwapNodesinPairs24 test = new SwapNodesinPairs24();
		int[] nodes = {1,2,3};
		ListNode head = LinkListFunction.createListFromArray(nodes);
		LinkListFunction.printLinkList(head);
		head = test.swapPairs(head);
		LinkListFunction.printLinkList(head);
	}
}
