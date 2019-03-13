package leetcodeDynamicPrograming;

public class ArithmeticSlices413 {
	//我的解法：归纳法
    public static int numberOfArithmeticSlices(int[] A) {
    	if(A == null||A.length<3) return 0;
    	int totalNum = 0;
    	int left = 0;
    	int right = 1;
    	int curGap = A[1] - A[0];
        for(int i=2;i<A.length;i++) {
        	right = i;
        	if(A[i] - A[i-1] != curGap) {//最大连续序列
        		if(right-left>2) {//只有长度大于等于3才会形成等差数列
        			totalNum += combineNum(right-left);
        		}
        		left = i - 1;
        		curGap = A[i] - A[i-1];
        	}
        }
        if(right - left + 1 > 2) totalNum += combineNum(right - left + 1) ;//最后一个长度大于等于3，但最后一个元素也在内的最长序列再循环中没有计算到
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
    //作者解法：动态规划法
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
