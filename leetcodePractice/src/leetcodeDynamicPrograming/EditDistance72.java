package leetcodeDynamicPrograming;

public class EditDistance72 {
	//参考网上做法
	//dp[i][i]:字符串1的前i个字符转化为字符串2的前j个字符最少需要多少步
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        //初始化
        for(int i=0;i<=m;i++) 	dp[i][0] = i;
        for(int j=0;j<=n;j++) 	dp[0][j] = j;
        for(int i=1;i<=m;i++) {
        	for(int j=1;j<=n;j++) {
        		if(word1.charAt(i-1)==word2.charAt(j-1)) {
        			dp[i][j] = dp[i-1][j-1];
        		}else {
        			//dp[i][j]可以由dp[i-1][j-1]采用replace操作转化，也可由dp[i-1][j]或者dp[i][j-1]由增加、删除一步操作得到
					dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1], dp[i-1][j]))+1;
				}
        	}
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
		EditDistance72 test = new EditDistance72();
		String word1 = "";
		String word2 = "a";
		System.out.println(test.minDistance(word1, word2));
		}
}
