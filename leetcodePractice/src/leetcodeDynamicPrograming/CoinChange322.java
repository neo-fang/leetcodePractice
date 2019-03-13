package leetcodeDynamicPrograming;

import java.util.Arrays;

public class CoinChange322 {
	//�ҵĽⷨ����̬�滮������ WordBreak139������ͬ��ֻ�Ǹ�������ʱ��ͬ��������ȫ��������
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];//dp[i]:����Ϊi�Ľ�����ٿ��ɶ��ٸ�������
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
