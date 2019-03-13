package leetcodePractice;

public class HouseRobber198 {
    //�ݹ�ⷨ
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
    	robMoney+= nums[curHouse];//͵�˵�ǰ���
    	doRob(nums, curHouse+2, robMoney);//�����������ӱ����͵һ��
    	doRob(nums, curHouse+3, robMoney);
    }
    
    //�ǵݹ�ⷨ���������߽ⷨ��
    public static int rob2(int[] nums) {
    	int pre1 = 0;//���ٵ���һ��ʱ�����������
    	int pre2 = 0;//���ٵ����ϼҵ����������
    	int cur = 0;//��ǰ���ٵ����Ǯ��
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
