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
	//解法1，当没有空间复杂度要求时，采用集合解决该问题最简单
	public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodeSet = new HashSet<>();
        while(head!=null) {
        	if(nodeSet.contains(head)) return true;
        	nodeSet.add(head);
        	head = head.next;
        }
        return false;
    }
	
	//解法2，若有空间复杂度要求，应当采用两步指针和单步指针进行循环
	public boolean hasCycle2(ListNode head) {
		if(head==null) return false;
		ListNode p1 = head;//单步指针
		ListNode p2 = head.next;//两步指针
		while(p1!=null&&p2!=null&&p2.next!=null) {
			if(p1==p2) return true;
			p1 = p1.next;
			p2 = p2.next.next;
		}
		return false;
	}
}
