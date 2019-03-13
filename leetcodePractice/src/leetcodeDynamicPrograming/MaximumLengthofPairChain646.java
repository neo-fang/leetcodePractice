package leetcodeDynamicPrograming;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumLengthofPairChain646 {
	//我的解法1：贪心算法（跟一个会场最多安排多少场会议相似）：用将所有元素按照结束时间添加进小根堆，
	//每次取出最早结束的时间对，比较其开始时间与当前结束之间的大小，合理则序列长度加1，取下一个元素
    public static int findLongestChain(int[][] pairs) {
    	PriorityQueue<int[]> pair = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);//以第二元素为比较元素小根堆
    	int end = Integer.MIN_VALUE;
    	int maxLength = 0;
    	for(int[] tmp:pairs) {
    		pair.add(tmp);
    	}
    	while(!pair.isEmpty()) {
    		int[] tmp = pair.poll();
    		if(tmp[0]>end) {
    			maxLength ++;
    			end = tmp[1];
    		}
    	}
    	return maxLength;
    }
    //我的解法2：动态规划法（与LongestIncreasingSubsequence300解法相同）。状态: dp[i]表示以pairs[i]为结尾最长连续数对，状态更新规则：dp[i]=max{dp[j]+1|j=0,1,2,...i-1,pairs[i][0]>pairs[j][1]}
   //具体算法：首先将所有的数对pairs按照第二元素最小排序，然后依次遍历每个元素，更新dp[i]，最后还需要遍历dp数组，得到最大值
   public static int findLongestChain2(int[][] pairs) {
	   int n = pairs.length;
	   int[] dp = new int[n];
	   int max = 1;
	   int length = 1;
	   Arrays.sort(pairs, (o1,o2)->o1[1]-o2[1]);//(o1,o2)->o1[1]-o2[1]是比较器的一种简单写法
	   for(int i=0;i<n;i++) {
		   for(int j=0;j<i;j++) {
			   if(pairs[i][0]>pairs[j][1]) {
				   max = Math.max(max, dp[j]+1);
			   }
		   }
		   dp[i] = max;
		   length = Math.max(max, length);
	   }
	   return length;
   }
    
    public static void main(String[] args) {
    	int[][] pairs = {{1,2}, {3,4}, {4,5},{5,6}};
    	System.out.println(findLongestChain2(pairs));
	}
}
