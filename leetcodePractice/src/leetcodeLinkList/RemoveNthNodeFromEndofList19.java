package leetcodeLinkList;

public class RemoveNthNodeFromEndofList19 {
	//�ҵĽⷨ����������ָ��p1��p2��p1����p2ָ��n���ڵ㣬��p1�����βendʱ��p2����end-n
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        //p1����n��
        for(int i=0;i<n;i++) {
        	p1 = p1.next;
        }
        //n����������ʱ��ֱ��ɾ��ͷ���
        if(p1==null) return head.next;
        //p1���յ㣬p2��������n��λ��
        while(p1.next!=null) {
        	p1 = p1.next;
        	p2 = p2.next;
        }
        p2.next = p2.next.next;//ɾ��p2����Ľڵ㣨������n���ڵ㣩
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
