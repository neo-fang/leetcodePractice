package leetcodeLinkList;

import java.util.Stack;

public class AddTwoNumbersII445 {
	//我的解法：先转化为两个数字，相加后转化为链表
	//错误，当链表长度较长时，会产生溢出
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1;
        int num2;
        StringBuilder tmp = new StringBuilder();
        while(l1!=null) {
        	tmp.append(l1.val);
        	l1 = l1.next;
        }
        num1 = Integer.parseUnsignedInt(tmp.toString());
        tmp.delete(0, tmp.length());
        while(l2!=null) {
        	tmp.append(l2.val);
        	l2 = l2.next;
        }
        num2 = Integer.parseUnsignedInt(tmp.toString());
        return intToLinkList(num1+num2);
    }
    public ListNode intToLinkList(int num) {
		ListNode head = new ListNode(-1);
		ListNode tail = null;
		while(num!=0) {
			 ListNode tmp = new ListNode(num%10);
			 tail = head.next;
			 head.next = tmp;
			 tmp.next = tail;
			 num = num/10;
		}
		return head.next;
	}
    
    //作者解法（用栈）
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }
    
    public static void main(String[] args) {
		AddTwoNumbersII445 test = new AddTwoNumbersII445();
		int[] nodes1 = {7,2,4,3};
		int[] nodes2 = {5,6,4};
		ListNode l1 = LinkListFunction.createListFromArray(nodes1);
		ListNode l2 = LinkListFunction.createListFromArray(nodes2);
		ListNode head = test.addTwoNumbers(l1, l2);
		LinkListFunction.printLinkList(head);
	}
}
