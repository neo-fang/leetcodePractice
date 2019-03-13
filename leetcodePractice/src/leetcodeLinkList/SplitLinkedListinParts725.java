package leetcodeLinkList;

public class SplitLinkedListinParts725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        ListNode tmp = root;
        ListNode head = root;
        ListNode[] res = new ListNode[k];//Ĭ�ϳ�ʼ��Ϊnull
        if(root == null) return res;
        while(tmp!=null) {
        	tmp = tmp.next;
        	length++;
        }
        int n = length/k;//ÿ������n���ڵ�
        int m = length%k;//ǰm�������һ���ڵ㣻
        int num = n+1;
        //��������в��
        tmp = root;
        if(length<k) k = length;
        //�ڵ���Ϊn������
        for(int i=1;i<=k;i++) {
        	res[i-1] = head;
        	if(i>m)  num = n;
        	for(int j=1;j<=num-1;j++) {
            	tmp = tmp.next;
            }
        	head = tmp.next;
        	tmp.next = null;
        	tmp = head;
        }
        return res;
    }
    
    public static void main(String[] args) {
		SplitLinkedListinParts725 test = new SplitLinkedListinParts725();
		int[] nodes = {1, 2, 3, 4, 5, 6, 7, 8};
		ListNode root = LinkListFunction.createListFromArray(nodes);
		ListNode[] res = test.splitListToParts(root, 10);
		System.out.println(res);
	}
}
