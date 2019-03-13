package leetcodePractice;

public class SingleElementinaSortedArray540 {
	//���ֽ������û��ʵ��O(logn)��ʱ�临�Ӷ�,�ռ临�Ӷ�O(1)��������Ҫ��
	/*
    public static int singleNonDuplicate(int[] nums) {
        for(int i = 0;i<nums.length-1;) {
        	if(nums[i] == nums[i+1]) {
        		i = i + 2;
        	}else {
        		return nums[i];
        	}
        }
        return nums[nums.length-1];
    }
    */
	//����Ҫ��O(logn)��ʱ�临�Ӷȣ���˱�Ȼ��Ҫ�����䲻�Ͻ��ж��֣������ڶ��ֲ���
	public static int singleNonDuplicate(int[] nums) {
		int l = 0;
		int r = nums.length-1;
		int m = (l+r)/2;
		while(l<r) {
			m = (l+r)/2;
			if(nums[m]==nums[m-1]) {
				if((m-l+1)%2==0) {
					l = m + 1;
				}else {
					r = m - 2;
				}
				continue;
			}
			if(nums[m] == nums[m+1]) {
				if((r-m+1)%2==0) {
					r = m - 1;
				}else {
					l = m + 2;
				}
				continue;
			}
		}
		return nums[l];
	}
    public static void main(String[] args) {
    	int[] nums = {1,1,2,2,3,3,4,4};
    	System.out.println(singleNonDuplicate(nums));
	}
}
