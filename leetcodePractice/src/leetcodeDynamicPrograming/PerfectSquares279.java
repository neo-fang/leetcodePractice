package leetcodeDynamicPrograming;

import java.util.Arrays;

public class PerfectSquares279 {
	//���Ͻⷨ1����ѧ�ⷨ������ƽ���Ͷ���������һ�����������ɱ�ʾΪ4��������ƽ���ͣ���ʵ��
	//���Ա�ʾΪ4�����ڵ�ƽ����֮�ͣ���ô����˵���ؽ��ֻ��1,2,3��4���е�һ��	;
	//����һ���������������4����ô���ǿ��԰�4��ȥ��������Ӱ����
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
	
	//���Ͻⷨ2(��̬�滮)
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

