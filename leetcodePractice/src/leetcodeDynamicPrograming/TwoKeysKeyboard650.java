package leetcodeDynamicPrograming;

public class TwoKeysKeyboard650 {
	//���Ͻⷨ���ݹ鷨��
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
    //��̬�滮�����������Ͻⷨ��
    public int minSteps2(int n) {
    	int[] dp = new int[n+1];//dp[i]���ճ�i������С����
    	dp[1] = 0;
    	for(int i=2;i<=n;i++) {
    		dp[i] = i;//�����
    		for(int j=2;j<=i/2;j++) {
    			if(i%j==0) {
    				//��i�ֿ��Գ�j��ģ�飬ÿ��ģ���СΪi/j�������ǰ����Ĺ��ɿ�֪��dp[i]= j+dp[i/j]
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
