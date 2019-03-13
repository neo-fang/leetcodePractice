package leetcodeLinkList;


public class IntersectionofTwoLinkedLists160 {
	//O(n)时间复杂度，O(1)空间复杂度，所有链表无环
	//参照作者解法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA!=pB) {
        	//pA = pA.next==null?headB:pA.next;//若其中有一个为空节点，访问空节点的next会出错
        	pA = pA==null?headB:pA.next;
        	//pB = pB.next==null?headA:pB.next;
        	pB = pB==null?headA:pB.next;
        }
        return pA;
    }
}
