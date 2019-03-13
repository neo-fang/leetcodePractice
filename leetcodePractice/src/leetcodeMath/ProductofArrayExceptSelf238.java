package leetcodeMath;

import java.util.Arrays;

public class ProductofArrayExceptSelf238 {
	//作者解法
    public int[] productExceptSelf(int[] nums) {
    	int n = nums.length;
        int[] product = new int[n];
        Arrays.fill(product, 1);
        //从左往右乘
        int left = 1;
        for(int i=1;i<n;i++) {
        	left *= nums[i-1];
        	product[i] = left;
        }
        int right = 1;
        for(int i=n-2;i>=0;i--) {
        	right *= nums[i+1];
        	product[i] *= right;
        }
        return product;
    }
    
    public static void main(String[] args) {
		ProductofArrayExceptSelf238 test = new ProductofArrayExceptSelf238();
		int[] nums = {1,2,3,4};
		int[] res = test.productExceptSelf(nums);
		System.out.println(Arrays.toString(res));
	}
}
