package leetcodeDynamicPrograming;

import java.util.Arrays;

public class MinimumPathSum64 {
    //动态规划算法：建立数组minStep，其中minStep[i][j]表示从位置(i,j)到最后一个元素的最小距离，
	//先计算最底部和最右部数值，然后从右下角往左上角递推得到各个点与右下角的最小距离。
	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
        int[][] minStep = new int[m][n];
        //计算最右边与最后一个元素的最小距离
        minStep[m-1][n-1] = grid[m-1][n-1];
        for(int i=m-2;i>=0;i--) {
        	minStep[i][n-1] = minStep[i+1][n-1] + grid[i][n-1];
        }
        //计算底部与最后一个元素grid[m-1][n-1]的最小距离
        for(int j=n-2;j>=0;j--) {
        	minStep[m-1][j] = minStep[m-1][j+1] + grid[m-1][j];
        }
        //从(m-2,n-2)的位置开始，往左上角递推得到所有位置与右下角的最小距离
        for(int i=m-2;i>=0;i--) {
        	for(int j=n-2;j>=0;j--) {
        		minStep[i][j] = Math.min(minStep[i+1][j], minStep[i][j+1]) + grid[i][j];
        	}
        }
        return minStep[0][0];
    }
	
	//动态规划+滚动数组
	public static int minPathSum2(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[] minStep = new int[n];
		Arrays.fill(minStep, Integer.MAX_VALUE);
		minStep[n-1] = 0;
		for(int i=m-1;i>=0;i--) {
			minStep[n-1] += grid[i][n-1];
			for(int j = n-2;j>=0;j--) {
				minStep[j] = Math.min(minStep[j], minStep[j+1]) + grid[i][j];
			}
		}
		return minStep[0];
	}
	
	public static void main(String[] args) {
		int[][] grid = {
				  {1,3,1},
				  {1,5,1},
				  {4,2,1}
		};
		System.out.println(minPathSum2(grid));
	}
}
