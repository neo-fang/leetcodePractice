package leetcodeDynamicPrograming;

import java.util.Arrays;

public class PerfectSquares279 {
	//网上解法1（数学解法）：四平方和定理——任意一个正整数均可表示为4个整数的平方和，其实是
	//可以表示为4个以内的平方数之和，那么就是说返回结果只有1,2,3或4其中的一个	;
	//由于一个数如果含有因子4，那么我们可以把4都去掉，并不影响结果
	public static int numSquares(int n) {
		while (n % 4 == 0) n /= 4;
		if (n % 8 == 7) return 4;
		for (int a = 0; a * a <= n; ++a) {
		    int b = (int) Math.sqrt(n - a * a);
		    if (a * a + b * b == n) {
		        //return a + b;
		    	return a==0||b==0?1:2;
		    }
		}
		return 3;
	}
	
	//网上解法2(动态规划)
	public static int numSquares2(int n) {
	        int[] dp = new int[n+1];
	        Arrays.fill(dp, Integer.MAX_VALUE);
	        dp[0] = 0;
	        for (int i = 0; i <= n; ++i) {
	            for (int j = 1; i + j * j <= n; ++j) {
	                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
	            }
	        }
	        return dp[n];
	}
	public static void main(String[] args) {
		int n =8;
		System.out.println(numSquares2(n));
	}
}

