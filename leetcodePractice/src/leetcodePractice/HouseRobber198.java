package leetcodePractice;

public class HouseRobber198 {
    //递归解法
	static int maxMoney = 0;
	public static int rob(int[] nums) {
		if(nums == null||nums.length==0)	return 0;
		int robMoney = 0;
        doRob(nums, 0, robMoney);
        doRob(nums, 1, robMoney);
        return maxMoney;
    }
    public static void doRob(int[] nums,int curHouse,int robMoney) {
    	if(curHouse>=nums.length) {
    		maxMoney = maxMoney>robMoney?maxMoney:robMoney;
    		return;
    	}
    	robMoney+= nums[curHouse];//偷了当前这家
    	doRob(nums, curHouse+2, robMoney);//相临两个房子必须得偷一个
    	doRob(nums, curHouse+3, robMoney);
    }
    
    //非递归解法（参照作者解法）
    public static int rob2(int[] nums) {
    	int pre1 = 0;//抢劫到上一家时的最大抢劫量
    	int pre2 = 0;//抢劫到上上家的最大抢劫量
    	int cur = 0;//当前抢劫的最大钱数
    	for(int i=0;i<nums.length;i++) {
    		cur = Math.max(pre1, nums[i]+pre2);
    		pre2 = pre1;
    		pre1 = cur;
    	}
    	return cur;
    }
    
    public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		System.out.println(rob2(nums));
	}
}
