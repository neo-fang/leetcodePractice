package leetcodeLinkList;

public class RemoveNthNodeFromEndofList19 {
	//我的解法：设置两个指针p1、p2，p1领先p2指针n个节点，当p1到达结尾end时，p2到达end-n
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        //p1先走n步
        for(int i=0;i<n;i++) {
        	p1 = p1.next;
        }
        //n等于链表长度时，直接删除头结点
        if(p1==null) return head.next;
        //p1到终点，p2到倒数第n个位置
        while(p1.next!=null) {
        	p1 = p1.next;
        	p2 = p2.next;
        }
        p2.next = p2.next.next;//删除p2后面的节点（倒数第n个节点）
        return head;
    }
    
    public static void main(String[] args) {
		RemoveNthNodeFromEndofList19 test = new RemoveNthNodeFromEndofList19();
		int[] nodes = {1,2,3};
		ListNode head = LinkListFunction.createListFromArray(nodes);
		LinkListFunction.printLinkList(head);
		head = test.removeNthFromEnd(head, 3);
		LinkListFunction.printLinkList(head);
	}
}
