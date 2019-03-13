package leetcodeDynamicPrograming;

public class TwoKeysKeyboard650 {
	//网上解法（递归法）
    public int minSteps(int n) {
            if (n == 1) return 0;
            int res = n;
            for (int i = n - 1; i > 1; --i) {
                if (n % i == 0) {
                    res = Math.min(res, minSteps(n / i) + i);
                }
            }
            return res;
        }
    //动态规划法（参照网上解法）
    public int minSteps2(int n) {
    	int[] dp = new int[n+1];//dp[i]：凑成i所需最小步数
    	dp[1] = 0;
    	for(int i=2;i<=n;i++) {
    		dp[i] = i;//最大步数
    		for(int j=2;j<=i/2;j++) {
    			if(i%j==0) {
    				//若i分可以成j个模块，每个模块大小为i/j，则分析前几项的规律可知，dp[i]= j+dp[i/j]
    				dp[i] = Math.min(dp[i],j+dp[i/j]);
    				//dp[i] = j+dp[i/j];
    			}
    		}
    	}
    	return dp[n];
    }
    public static void main(String[] args) {
    	TwoKeysKeyboard650 test = new TwoKeysKeyboard650();
		int n = 6;
		System.out.println(test.minSteps2(n));
	}
}
