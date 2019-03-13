package leetcodeDynamicPrograming;

public class PartitionEqualSubsetSum416 {
    public static boolean canPartition(int[] nums) {
    	if(nums == null||nums.length==0) return false;
        int totalSum = sum(nums);
        if(totalSum%2!=0) return false;
        return hasEqual(nums, totalSum/2, 0);
        
    } 
    public static boolean hasEqual(int[] nums,int target,int curIndex) {
    	//if(target == 0) return true;
    	if(curIndex==nums.length||target<0) return false;
    	for(int i=curIndex;i<nums.length;i++) {
    		if(nums[i] == target) return true;
    		if(hasEqual(nums, target, i+1)||hasEqual(nums, target-nums[curIndex], i+1)) {
    			return true;
    		}//不加入当前元素
    	}
		return false;
	}    
    public static int sum(int[] nums) {
		int tmp = 0;
    	for(int a:nums) {
    		tmp+=a;
    	}
    	return tmp;
	}
    
    public static void main(String[] args) {
		int[] nums = {1, 3, 9,15};
		System.out.println(canPartition(nums));
	}
}
