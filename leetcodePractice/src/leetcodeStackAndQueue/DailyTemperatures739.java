package leetcodeStackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {
	//我的解法：暴力解法
    public int[] dailyTemperatures(int[] T) {
    	int n = T.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++) {
        	int cnt = 1;
        	int j;
        	for(j=i+1;j<n&&T[j]<=T[i];j++) {
        			cnt++;
        	}
        	if(j<n) {
        		res[i] = cnt;
        	}
        }
        return res;
    }
    //作者解法
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < n; curIndex++) {
            while (!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]) {
                int preIndex = indexs.pop();
                dist[preIndex] = curIndex - preIndex;
            }
            indexs.add(curIndex);
        }
        return dist;
    }
    
    public static void main(String[] args) {
    	int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
    	DailyTemperatures739 test = new DailyTemperatures739();
    	System.out.println(Arrays.toString(test.dailyTemperatures2(T)));
	}
}
