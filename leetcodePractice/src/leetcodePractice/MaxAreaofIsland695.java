package leetcodePractice;

public class MaxAreaofIsland695 {
    public static int maxAreaOfIsland(int[][] grid) {
    	final int row = grid.length;
    	final int column = grid[0].length;
    	int maxArea = 0;
    	for(int i=0;i<row;i++) {
    		for(int j=0;j<column;j++) {
    			if(grid[i][j]==1) {
    				//grid[i][j] = -1;//��Ԫ�ر���Ⱦ
    				//infect(i, j, grid, row, column, direction);
    				maxArea =Math.max(infect(grid,i, j,  row, column),maxArea);
    			}
    		}
    	}
    	return maxArea;
    }
    /*ԭ����ȫ��ȷ��Ϊʲô�����
    public static void infect(int x, int y,int[][] grid,int row,int column,int[][] direction) {//��Ⱦ�㷨�����Աߵ��ڽ�Ԫ��ȫ����Ϊһ��
		for(int[] tmp:direction) {//Ϊʲô��x=2��y=2ʱ��tmpֻȡ��ǰ����������������ֱ��������
			int nextX = tmp[0]+x;
			int nextY = tmp[1]+y;
			if(nextX<0||nextX>=column||nextY<0||nextY>=row) continue;
			if(grid[nextX][nextY] == 1) {
				grid[nextX][nextY] = -1;//��ʾ����Ⱦ
				x = nextX;
				y = nextY;
				infect(x, y, grid, row, column,direction);
			} 
		}
	}*/
    public static int infect(int[][] m, int i, int j, int N, int M) {
		if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
			return 0;
		}
		m[i][j] = -1;
		int res = 1;
		res += infect(m, i + 1, j, N, M);
		res += infect(m, i - 1, j, N, M);
		res += infect(m, i, j + 1, N, M);
		res += infect(m, i, j - 1, N, M);
		return res;
	}
    
    public static void main(String[] args) {
		int[][] grid = {
				{1,0,0,1,0},
				{1,1,0,0,0},
				{0,0,1,1,0},
				{1,0,1,0,1},
				{1,1,1,1,0}
		};
		System.out.println(maxAreaOfIsland(grid));
	}
}
