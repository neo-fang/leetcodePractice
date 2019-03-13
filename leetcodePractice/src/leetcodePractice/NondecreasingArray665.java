package leetcodePractice;

public class NondecreasingArray665 {
	public static boolean checkPossibility(int[] nums) {
        int changeTime = 0;
        for(int i=0;i<nums.length-1;i++) {
        	if(changeTime>1) return false;
        	if(nums[i]>nums[i+1]) {
        		changeTime++;
        		if(i>0&&nums[i-1]>nums[i+1]) nums[i+1] = nums[i];
        	}
        }
        if(changeTime>1) return false;
        return true;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,4,4,3,7,2,9};
		System.out.println(checkPossibility(nums));
	}
//	public static boolean nonDecreasing(int[] nums) {
//		for(int i=0;i<nums.length-1;i++) {
//			if(nums[i]>nums[i+1]) return false;
//		}
//		return true;
//	}
}
