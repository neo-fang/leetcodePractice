package leetcodeDynamicPrograming;

public class DeleteOperationforTwoStrings583 {
	//此题本质上是求两个字符串的最长公共子序列，dp[i][j]：字符串1的长度为i的子串与字符串2的长度为j的子串的最大公共子串
    public int minDistance(String word1, String word2) {
    	int m = word1.length();
    	int n = word2.length();
    	int[][] dp = new int[m+1][n+1];//dp[0][j]和dp[i][0]全部为0，因为有字符串长度为0
    	for(int i=1;i<=m;i++) {
    		for(int j=1;j<=n;j++) {
    			if(word1.charAt(i-1)==word2.charAt(j-1)) {
    				dp[i][j] = 1+dp[i-1][j-1];
    			}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
    		}
    	}
    	return m+n-2*dp[m][n];
    }
    public static void main(String[] args) {
		DeleteOperationforTwoStrings583 test = new DeleteOperationforTwoStrings583();
		String word1="sea";
		String word2 = "seta";
		System.out.println(test.minDistance(word1, word2));
	}
}
