package leetcodeLinkList;


public class IntersectionofTwoLinkedLists160 {
	//O(n)ʱ�临�Ӷȣ�O(1)�ռ临�Ӷȣ����������޻�
	//�������߽ⷨ
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA!=pB) {
        	//pA = pA.next==null?headB:pA.next;//��������һ��Ϊ�սڵ㣬���ʿսڵ��next�����
        	pA = pA==null?headB:pA.next;
        	//pB = pB.next==null?headA:pB.next;
        	pB = pB==null?headA:pB.next;
        }
        return pA;
    }
}
