package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions130 {
	//算法思想：对矩阵borad的四个边都进行检查，如有为'O'的位置，将该位置加入检查列表survival，
	//从survival列表中依次取出每个元素，对其进行DFS，标记经过的所有点'S'。
	//最后，对矩阵board进行一遍遍历，将所有标记为'O'的点转化为'X'，将所有标记为'S'的点转化为'O'
    static class Point{
    	int x;
    	int y;
    	public Point(int x,int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
	public static void solve(char[][] board) {
		if(board.length == 0) return;
		final int row = board.length;
		final int column = board[0].length;
		final int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
		List<Point> survival = new ArrayList<Point>();
        for(int i=0;i<column;i++) {
        	if(board[0][i] == 'O') survival.add(new Point(0, i));
        	if(board[row-1][i]=='O') survival.add(new Point(row-1, i));
        }
        for(int j=0;j<row;j++) {
        	if(board[j][0]=='O') survival.add(new Point(j, 0));
        	if(board[j][column-1]=='O') survival.add(new Point(j, column-1));
        }
        for(Point point:survival) {
        	if(board[point.x][point.y] == 'O') {
        		findSafeNode(point, board, row, column, direction);
        	}
        }
        for(int i = 0;i<row;i++) {
        	for(int j=0;j<column;j++) {
        		if(board[i][j]=='O') board[i][j] = 'X';
        		if(board[i][j]=='S') board[i][j] = 'O';
        	}
        }
    }
	
	public static void findSafeNode(Point point, char[][] board,int row, int column,int[][] direction) {
		board[point.x][point.y] = 'S';
		for(int[] tmpDir:direction) {
			int nextX = point.x+tmpDir[0];
			int nextY = point.y+tmpDir[1];
			if(nextX<0||nextX>=row||nextY<0||nextY>=column)	continue;
			if(board[nextX][nextY]=='O') {
				Point nextPoint = new Point(nextX, nextY);
				findSafeNode(nextPoint, board, row, column, direction);
			}
		}
	}
	
	public static void main(String[] args) {
//		char[][] board = {
//				{'X','O','O','X'},
//				{'X','X','X','X'},
//				{'X','O','X','O'},
//				{'X','X','X','X'}
//		};
		char[][] board = {
				{'X','O','X','O','X','O'},
				{'O','X','O','X','O','X'},
				{'X','O','X','O','X','O'},
				{'O','X','O','X','O','X'}
		};
		solve(board);
		System.out.println();
	}
    /*
    X X X X
	X X X X
	X X X X
	X O X X
     * */
}
