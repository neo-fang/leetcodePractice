package leetcodePractice;

public class FindMinimuminRotatedSortedArray153 {
    public static int findMin(int[] nums) {
    	int i = 0;
        while(i<nums.length-1&&nums[i]<nums[i+1]) i++;
        if(i<nums.length-1) return nums[i+1];
        else return nums[0];
    }
    
    public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(findMin(nums));
	}
}
