package leetcodeDynamicPrograming;

import java.util.Arrays;

public class CoinChange322 {
	//我的解法（动态规划），与 WordBreak139做法相同，只是更新条件时不同，属于完全背包问题
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];//dp[i]:总数为i的金币最少可由多少个金币组成
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++) {
        	for(int coin:coins) {
        		if(coin<=i&&dp[i-coin]>=0) {
        			if(dp[i]==-1) dp[i] = 1+dp[i-coin];
        			else {
        				dp[i] = Math.min(dp[i], 1+dp[i-coin]);
					}
        		}
        	}
        }
        return dp[amount];
    }
    public static void main(String[] args) {
		CoinChange322 exam = new CoinChange322();
		int[] coins = {2, 5};
		int amount =3 ;
		System.out.println(exam.coinChange(coins, amount));
	}
}
