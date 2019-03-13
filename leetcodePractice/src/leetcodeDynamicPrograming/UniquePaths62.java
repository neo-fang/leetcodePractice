package leetcodeDynamicPrograming;

public class UniquePaths62 {
   //动态规划
	public static int uniquePaths(int m, int n) {
        if(m<=0||n<=0) return 0;
        if(m==1&&n==1) return 1;
        int[][] pathNum = new int[m][n];
        pathNum[0][0] = 1;
        for(int i=1;i<m;i++) {
        	pathNum[i][0] = 1;
        }
        for(int j=1;j<n;j++) {
        	pathNum[0][j] = 1;
        }
        for(int i = 1;i<m;i++) {
        	for(int j=1;j<n;j++) {
        		pathNum[i][j] = pathNum[i-1][j] + pathNum[i][j-1];
        	}
        }
        return pathNum[m-1][n-1];
    }
	//动态规划+滚动数组
    public static int uniquePaths2(int m, int n) {
        if(m<=0||n<=0) return 0;
        if(m==1&&n==1) return 1;
        int[] pathNum = new int[n];
        pathNum[0] = 1;
        for(int i=0;i<m;i++) {
        	for(int j=1;j<n;j++) {
        		pathNum[j] += pathNum[j-1]; 
        	}
        }
        return pathNum[n-1];
    }
    
    public static void main(String[] args) {
    	int m = 2;
    	int n = 3;
    	System.out.println(uniquePaths2(m, n));
	}
}
