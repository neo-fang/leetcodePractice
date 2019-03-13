package leetcodeLinkList;

public class PalindromeLinkedList234 {
    //O(n) time and O(1) space
	//解法：将链表一份为2，并将其中一部分反转，比较其余另外一半是否相等
	public boolean isPalindrome(ListNode head) {
		if(head==null) return true;
        ListNode former = head;
        ListNode later = head;
        ListNode pre = null;
        ListNode next = former.next;
        //寻找中点，同时反转前半部分链表
        while(later!=null&&later.next!=null&&later.next.next!=null) {
        	later = later.next.next;//每次走两步
        	former.next = pre;
        	pre = former;
        	former = next;//每次走一步
        	next = former.next;    	
        }
        //later指向后半部分链表首节点，former指向逆序的前半部分节点
        if(later.next==null) {
        	later = former.next;
        	former = pre;
        }else {
        	later = former.next;
        	former.next = pre;
        }
        
        while(former!=null&&later!=null) {
        	if(former.val!=later.val) return false;
        	former = former.next;
        	later = later.next;
        }
        return true;
    }
	public static void main(String[] args) {
		PalindromeLinkedList234 test = new PalindromeLinkedList234();
		int[] nodes = {};
		ListNode head = LinkListFunction.createListFromArray(nodes);
		System.out.println(test.isPalindrome(head));
	}
}
