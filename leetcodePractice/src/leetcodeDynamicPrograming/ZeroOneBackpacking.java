package leetcodeDynamicPrograming;

public class ZeroOneBackpacking {//0-1����
	public static int knapsack(int W, int N, int[] weights, int[] values) {//N����Ʒ�����������W
		int[][] dp = new int[N+1][W+1];//dp[i][j] ��ʾǰ i ����Ʒ��������� j ��������ܴﵽ������ֵ
		for(int i=1;i<=N;i++) {
			int w = weights[i-1];
			int v = values[i-1];
			for(int j=1;j<=W;j++) {
				if(w<=j) {
					dp[i][j] = Math.max(dp[i-1][j], v+dp[i-1][j-w]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[N][W];
	}

	public static void main(String[] args) {
		int W = 5;
		int N = 3;
		int[] weights = {1,2,3};
		int[] values = {6,10,12};
		System.out.println(knapsack(W, N, weights, values));
	}
}
