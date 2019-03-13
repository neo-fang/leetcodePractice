package leetcodeDynamicPrograming;

public class ArithmeticSlices413 {
	//�ҵĽⷨ�����ɷ�
    public static int numberOfArithmeticSlices(int[] A) {
    	if(A == null||A.length<3) return 0;
    	int totalNum = 0;
    	int left = 0;
    	int right = 1;
    	int curGap = A[1] - A[0];
        for(int i=2;i<A.length;i++) {
        	right = i;
        	if(A[i] - A[i-1] != curGap) {//�����������
        		if(right-left>2) {//ֻ�г��ȴ��ڵ���3�Ż��γɵȲ�����
        			totalNum += combineNum(right-left);
        		}
        		left = i - 1;
        		curGap = A[i] - A[i-1];
        	}
        }
        if(right - left + 1 > 2) totalNum += combineNum(right - left + 1) ;//���һ�����ȴ��ڵ���3�������һ��Ԫ��Ҳ���ڵ��������ѭ����û�м��㵽
        return totalNum;
    }
    public static int combineNum(int n) {
		if(n<3) return 0;
		if(n==3) return 1;
		int num = 0;
		for(int i=3;i<=n;i++) {
			num += n - i + 1;
		}
		return num;
	}
    //���߽ⷨ����̬�滮��
    public static int numberOfArithmeticSlices2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int total = 0;
        for (int cnt : dp) {
            total += cnt;
        }
        return total;
    }
    
    public static void main(String[] args) {
		int[] A = {1,2,3,4};
		System.out.println(numberOfArithmeticSlices2(A));
	}
    /*example
    A = [1, 2, 3, 4]
	return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
	*/
    
}
