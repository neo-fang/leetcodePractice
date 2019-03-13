package leetcodeDynamicPrograming;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumLengthofPairChain646 {
	//�ҵĽⷨ1��̰���㷨����һ���᳡��ల�Ŷ��ٳ��������ƣ����ý�����Ԫ�ذ��ս���ʱ����ӽ�С���ѣ�
	//ÿ��ȡ�����������ʱ��ԣ��Ƚ��俪ʼʱ���뵱ǰ����֮��Ĵ�С�����������г��ȼ�1��ȡ��һ��Ԫ��
    public static int findLongestChain(int[][] pairs) {
    	PriorityQueue<int[]> pair = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);//�Եڶ�Ԫ��Ϊ�Ƚ�Ԫ��С����
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
    //�ҵĽⷨ2����̬�滮������LongestIncreasingSubsequence300�ⷨ��ͬ����״̬: dp[i]��ʾ��pairs[i]Ϊ��β��������ԣ�״̬���¹���dp[i]=max{dp[j]+1|j=0,1,2,...i-1,pairs[i][0]>pairs[j][1]}
   //�����㷨�����Ƚ����е�����pairs���յڶ�Ԫ����С����Ȼ�����α���ÿ��Ԫ�أ�����dp[i]�������Ҫ����dp���飬�õ����ֵ
   public static int findLongestChain2(int[][] pairs) {
	   int n = pairs.length;
	   int[] dp = new int[n];
	   int max = 1;
	   int length = 1;
	   Arrays.sort(pairs, (o1,o2)->o1[1]-o2[1]);//(o1,o2)->o1[1]-o2[1]�ǱȽ�����һ�ּ�д��
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
