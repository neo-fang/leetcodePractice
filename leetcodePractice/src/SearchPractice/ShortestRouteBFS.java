package SearchPractice;

import java.util.LinkedList;
import java.util.Queue;
/**
 * ��Ŀ���������� (0, 0) λ�õ� (tr, tc) λ�õ����·�����ȡ�
 * [[1,1,0,1],
 [1,0,1,0],
 [1,1,1,1],
 [1,0,1,1]]
 *1 ��ʾ���Ծ���ĳ��λ��
 */
//�ҵĽⷨ
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
		Queue<Point> pointQueue = new LinkedList<Point>();//���ڴ�Ÿ����
		final int row = grids.length;
		final int column = grids[0].length; 
		final int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};//���������ĸ�����
		boolean[][] visited = new boolean[row][column];//�������������ʼֵ��false
		Point origin = new Point(0,0,0);//��ʼ������Ϊԭ��
		pointQueue.add(origin);
		while(!pointQueue.isEmpty()) {
			Point curPoint = pointQueue.poll();
			if(curPoint.x == tr&&curPoint.y==tc) return curPoint.shortest;
			for(int[] tmpDir:direction) {
				if(curPoint.x+tmpDir[0]>=0&&curPoint.x+tmpDir[0]<column&&curPoint.y+tmpDir[1]>=0&&curPoint.y+tmpDir[1]<row//�ж��±겻Խ��
						&&(!visited[curPoint.x+tmpDir[0]][curPoint.y+tmpDir[1]])&&grids[curPoint.x+tmpDir[0]][curPoint.y+tmpDir[1]]==1) {//�ж��Ƿ��ߵ�ͨ
					pointQueue.add(new Point(curPoint.x+tmpDir[0], curPoint.y+tmpDir[1],curPoint.shortest+1));
				}	
			}
			visited[curPoint.x][curPoint.y] = true;//�Ѿ�������еı��һ�£������ٽ������
		}
		return -1;
	}
	//���߽ⷨ(�޷��ҵ�Pair��)
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
	            grids[cr][cc] = 0; // ���
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
