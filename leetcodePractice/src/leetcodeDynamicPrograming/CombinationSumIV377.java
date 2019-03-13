package leetcodeDynamicPrograming;

public class CombinationSumIV377 {
    public int combinationSum4(int[] nums, int target) {//������ϵ�˳��
        int[] dp = new int[target+1];//dp[i]��ʾ����i�ж��������ɷ�ʽ����ʼֵΪ0
        dp[0] = 1;//��ʾ0�ķ���ֻ��һ�֣�����ȫ��Ϊ0�����dp[0]=0
        for(int i=1;i<=target;i++) {
        	for(int tmp:nums) {
        		if(tmp<=i) {
        			dp[i] = dp[i] + dp[i-tmp];//��dp[i-tmp]=0����dp[i]=dp[i]=0��dp[i]�Ӵ�С���������
        		}
        	}
        }
        return dp[target];
    }

    public static void main(String[] args) {
    	CombinationSumIV377 test = new CombinationSumIV377();
    	int[] nums = {3,5};
    	int target = 8;
    	System.out.println(test.combinationSum4(nums, target));
	}
}
