package leetcodeLinkList;

import java.util.Scanner;

class ListNode {    
	int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class LinkListFunction {
	//打印链表函数
	public static void printLinkList(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println();
	}
	
	//创建测试链表(无环)
	public static ListNode createTestList() {
		ListNode head = new ListNode(3);
		head.next = new ListNode(5);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(7);
		head.next.next.next.next = new ListNode(6);
		return head;
	}
	
	//键盘输入创建链表
	public static ListNode createListByKeyboard() {
		System.out.println("依次输入链表数据，按任意字符结束输入:");
		Scanner sc = new Scanner(System.in);
		while(!sc.hasNextInt());
		ListNode head = new ListNode(sc.nextInt());
		ListNode tmp = head;
		while(sc.hasNextInt()) {
			tmp.next = new ListNode(sc.nextInt());
			tmp = tmp.next;
		}
		sc.close();
		return head;
	}
	
	//由数组创建链表
	public static ListNode createListFromArray(int[] nodes) {
		ListNode head = new ListNode(nodes[0]);
		ListNode tmp = head;
		for(int i = 1;i<nodes.length;i++) {
			tmp.next = new ListNode(nodes[i]);
			tmp = tmp.next;
		}
		return head;
	}
	public static void main(String[] args) {
//		ListNode head = createListByKeyboard();
//		printLinkList(head);
		int[] nodes = {2,3,4,1};
		ListNode head = createListFromArray(nodes);
		printLinkList(head);
	}
}
