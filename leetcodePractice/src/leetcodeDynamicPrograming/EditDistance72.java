package leetcodeDynamicPrograming;

public class EditDistance72 {
	//�ο���������
	//dp[i][i]:�ַ���1��ǰi���ַ�ת��Ϊ�ַ���2��ǰj���ַ�������Ҫ���ٲ�
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        //��ʼ��
        for(int i=0;i<=m;i++) 	dp[i][0] = i;
        for(int j=0;j<=n;j++) 	dp[0][j] = j;
        for(int i=1;i<=m;i++) {
        	for(int j=1;j<=n;j++) {
        		if(word1.charAt(i-1)==word2.charAt(j-1)) {
        			dp[i][j] = dp[i-1][j-1];
        		}else {
        			//dp[i][j]������dp[i-1][j-1]����replace����ת����Ҳ����dp[i-1][j]����dp[i][j-1]�����ӡ�ɾ��һ�������õ�
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
