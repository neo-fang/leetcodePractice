package leetcodeDynamicPrograming;import leetcodePractice.FindMinimuminRotatedSortedArray153;

public class OnesandZeroes474 {
	//DFS法，不知道如何加入记忆数组（运算超时）
    public static int findMaxForm(String[] strs, int m, int n) {
    	int tmpMax = 0;
        maxNum(strs, m, n, 0, tmpMax);
        return max;
    }
    static int max = 0;
    public static void  maxNum(String[] strs, int m, int n,int curIndex,int tmpMax) {
		if(curIndex >= strs.length) {
			max = Math.max(max, tmpMax);
		}
		for(int i=curIndex;i<strs.length;i++) {
			int[] tmpCount = count(strs[i]);
			if(tmpCount[0]>m||tmpCount[1]>n) continue;
			tmpMax++;
			maxNum(strs, m-tmpCount[0], n-tmpCount[1], i+1,tmpMax);
			tmpMax--;
			maxNum(strs, m, n, i+1,tmpMax);		
			//tmpMax--;
		}
	}
    
    public static int[] count(String s) {
    	int[] countTmp = new int[2];
		for(char tmp:s.toCharArray()) {
			if(tmp == '0') countTmp[0]++;
			if(tmp == '1') countTmp[1]++;
		}
		return countTmp;
	}
    
    //作者解法：动态规划法
    public static int findMaxForm2(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {    // 每个字符串只能用一次
            int ones = 0, zeros = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
    
    public static void main(String[] args) {
		String[] strs = {"10", "0001", "111001", "1", "0"};
		int m = 5, n = 2;
		System.out.println(findMaxForm2(strs, m, n));
	}
}
