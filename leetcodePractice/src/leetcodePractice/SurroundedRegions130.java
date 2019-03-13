package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions130 {
	//�㷨˼�룺�Ծ���borad���ĸ��߶����м�飬����Ϊ'O'��λ�ã�����λ�ü������б�survival��
	//��survival�б�������ȡ��ÿ��Ԫ�أ��������DFS����Ǿ��������е�'S'��
	//��󣬶Ծ���board����һ������������б��Ϊ'O'�ĵ�ת��Ϊ'X'�������б��Ϊ'S'�ĵ�ת��Ϊ'O'
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
