package leetcodeLinkList;

public class PalindromeLinkedList234 {
    //O(n) time and O(1) space
	//�ⷨ��������һ��Ϊ2����������һ���ַ�ת���Ƚ���������һ���Ƿ����
	public boolean isPalindrome(ListNode head) {
		if(head==null) return true;
        ListNode former = head;
        ListNode later = head;
        ListNode pre = null;
        ListNode next = former.next;
        //Ѱ���е㣬ͬʱ��תǰ�벿������
        while(later!=null&&later.next!=null&&later.next.next!=null) {
        	later = later.next.next;//ÿ��������
        	former.next = pre;
        	pre = former;
        	former = next;//ÿ����һ��
        	next = former.next;    	
        }
        //laterָ���벿�������׽ڵ㣬formerָ�������ǰ�벿�ֽڵ�
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
