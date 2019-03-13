package SearchPractice;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 题目描述：求解从 (0, 0) 位置到 (tr, tc) 位置的最短路径长度。
 * [[1,1,0,1],
 [1,0,1,0],
 [1,1,1,1],
 [1,0,1,1]]
 *1 表示可以经过某个位置
 */
//我的解法
class Point{
	int x;
	int y;
	int shortest = Integer.MAX_VALUE;
	public Point(int x,int y,int shortest) {
		this.x = x;
		this.y = y;
		this.shortest = shortest;
	}
}
public class ShortestRouteBFS {
	public static int minPathLength(int[][] grids, int tr, int tc) {
		Queue<Point> pointQueue = new LinkedList<Point>();//用于存放各层点
		final int row = grids.length;
		final int column = grids[0].length; 
		final int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};//左右上下四个方向
		boolean[][] visited = new boolean[row][column];//布尔类型数组初始值是false
		Point origin = new Point(0,0,0);//初始点设置为原点
		pointQueue.add(origin);
		while(!pointQueue.isEmpty()) {
			Point curPoint = pointQueue.poll();
			if(curPoint.x == tr&&curPoint.y==tc) return curPoint.shortest;
			for(int[] tmpDir:direction) {
				if(curPoint.x+tmpDir[0]>=0&&curPoint.x+tmpDir[0]<column&&curPoint.y+tmpDir[1]>=0&&curPoint.y+tmpDir[1]<row//判断下标不越界
						&&(!visited[curPoint.x+tmpDir[0]][curPoint.y+tmpDir[1]])&&grids[curPoint.x+tmpDir[0]][curPoint.y+tmpDir[1]]==1) {//判断是否走的通
					pointQueue.add(new Point(curPoint.x+tmpDir[0], curPoint.y+tmpDir[1],curPoint.shortest+1));
				}	
			}
			visited[curPoint.x][curPoint.y] = true;//已经入过队列的标记一下，将不再进入队列
		}
		return -1;
	}
	//作者解法(无法找到Pair类)
	/*
	public int minPathLength2(int[][] grids, int tr, int tc) {
	    final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	    final int m = grids.length, n = grids[0].length;
	    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
	    queue.add(new Pair<>(0, 0));
	    int pathLength = 0;
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        pathLength++;
	        while (size-- > 0) {
	            Pair<Integer, Integer> cur = queue.poll();
	            int cr = cur.getKey(), cc = cur.getValue();
	            grids[cr][cc] = 0; // 标记
	            for (int[] d : direction) {
	                int nr = cr + d[0], nc = cc + d[1];
	                if (nr < 0 || nr >= m || nc < 0 || nc >= n || grids[nr][nc] == 0) {
	                    continue;
	                }
	                if (nr == tr && nc == tc) {
	                    return pathLength;
	                }
	                queue.add(new Pair<>(nr, nc));
	            }
	        }
	    }
	    return -1;
	}
	*/
	public static void main(String[] args) {
		int[][] grids = {{1,1,0,1},{1,0,1,0},{1,1,1,1},{1,0,1,1}};
		int tr = 2;
		int tc = 2;
		System.out.println(minPathLength(grids, tr, tc));
	}
}
