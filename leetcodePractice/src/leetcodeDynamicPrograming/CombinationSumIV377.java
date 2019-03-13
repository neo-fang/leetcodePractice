package leetcodeDynamicPrograming;

public class CombinationSumIV377 {
    public int combinationSum4(int[] nums, int target) {//考虑组合的顺序
        int[] dp = new int[target+1];//dp[i]表示数字i有多少总生成方式，初始值为0
        dp[0] = 1;//表示0的方法只有一种，就是全部为0，因此dp[0]=0
        for(int i=1;i<=target;i++) {
        	for(int tmp:nums) {
        		if(tmp<=i) {
        			dp[i] = dp[i] + dp[i-tmp];//若dp[i-tmp]=0，则dp[i]=dp[i]=0（dp[i]从此小到大迭代）
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
