package leetcodeStackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < 2*n; curIndex++) {
            while (!indexs.isEmpty() && nums[curIndex%n] > nums[indexs.peek()]) {
                int preIndex = indexs.pop();
                dist[preIndex] = nums[curIndex%n];
            }
            indexs.add(curIndex%n);
        }
        return dist;
    }
    public static void main(String[] args) {
		int[] nums = {1,3,2,1,2};
		NextGreaterElementII503 test = new NextGreaterElementII503();
		System.out.println(Arrays.toString(test.nextGreaterElements(nums)));
	}
}
