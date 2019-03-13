package leetcodeDynamicPrograming;

import java.util.Arrays;

public class MinimumPathSum64 {
    //��̬�滮�㷨����������minStep������minStep[i][j]��ʾ��λ��(i,j)�����һ��Ԫ�ص���С���룬
	//�ȼ�����ײ������Ҳ���ֵ��Ȼ������½������Ͻǵ��Ƶõ������������½ǵ���С���롣
	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
        int[][] minStep = new int[m][n];
        //�������ұ������һ��Ԫ�ص���С����
        minStep[m-1][n-1] = grid[m-1][n-1];
        for(int i=m-2;i>=0;i--) {
        	minStep[i][n-1] = minStep[i+1][n-1] + grid[i][n-1];
        }
        //����ײ������һ��Ԫ��grid[m-1][n-1]����С����
        for(int j=n-2;j>=0;j--) {
        	minStep[m-1][j] = minStep[m-1][j+1] + grid[m-1][j];
        }
        //��(m-2,n-2)��λ�ÿ�ʼ�������Ͻǵ��Ƶõ�����λ�������½ǵ���С����
        for(int i=m-2;i>=0;i--) {
        	for(int j=n-2;j>=0;j--) {
        		minStep[i][j] = Math.min(minStep[i+1][j], minStep[i][j+1]) + grid[i][j];
        	}
        }
        return minStep[0][0];
    }
	
	//��̬�滮+��������
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
