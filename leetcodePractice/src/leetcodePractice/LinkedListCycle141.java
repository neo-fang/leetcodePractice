package leetcodePractice;

import java.util.HashSet;

class ListNode {
	  int val;
	  ListNode next;
	  ListNode(int x) {
	        val = x;
	       next = null;
	  }
}
public class LinkedListCycle141 {
	//�ⷨ1����û�пռ临�Ӷ�Ҫ��ʱ�����ü��Ͻ�����������
	public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodeSet = new HashSet<>();
        while(head!=null) {
        	if(nodeSet.contains(head)) return true;
        	nodeSet.add(head);
        	head = head.next;
        }
        return false;
    }
	
	//�ⷨ2�����пռ临�Ӷ�Ҫ��Ӧ����������ָ��͵���ָ�����ѭ��
	public boolean hasCycle2(ListNode head) {
		if(head==null) return false;
		ListNode p1 = head;//����ָ��
		ListNode p2 = head.next;//����ָ��
		while(p1!=null&&p2!=null&&p2.next!=null) {
			if(p1==p2) return true;
			p1 = p1.next;
			p2 = p2.next.next;
		}
		return false;
	}
}
