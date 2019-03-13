package leetcodePractice;

public class MaxAreaofIsland695 {
    public static int maxAreaOfIsland(int[][] grid) {
    	final int row = grid.length;
    	final int column = grid[0].length;
    	int maxArea = 0;
    	for(int i=0;i<row;i++) {
    		for(int j=0;j<column;j++) {
    			if(grid[i][j]==1) {
    				//grid[i][j] = -1;//该元素被感染
    				//infect(i, j, grid, row, column, direction);
    				maxArea =Math.max(infect(grid,i, j,  row, column),maxArea);
    			}
    		}
    	}
    	return maxArea;
    }
    /*原理完全正确，为什么会出错？
    public static void infect(int x, int y,int[][] grid,int row,int column,int[][] direction) {//感染算法，将旁边的邻接元素全部归为一类
		for(int[] tmp:direction) {//为什么当x=2，y=2时，tmp只取了前两个数，后两个数直接跳过了
			int nextX = tmp[0]+x;
			int nextY = tmp[1]+y;
			if(nextX<0||nextX>=column||nextY<0||nextY>=row) continue;
			if(grid[nextX][nextY] == 1) {
				grid[nextX][nextY] = -1;//表示被感染
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
