package leetcodeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule207 {
	//解法1（秩排序算法）
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int n = prerequisites.length;
        //生成邻接表,同时初始化入度数组
		List<ArrayList<Integer>> edges = new ArrayList<>();
		for(int i=0;i<numCourses;i++) {
			edges.add(new ArrayList<Integer>());
		}
		//List<Integer>[] edges = new List[numCourses];
		int[] in = new int[numCourses];
        for(int i=0;i<n;i++) {
        	int left = prerequisites[i][0];
        	int right = prerequisites[i][1];
        	edges.get(left).add(right);//默认0指向1（左指向右）
        	in[right]++;
        }
        //将入度为0的顶点压栈，取出栈中每个顶点删除，其相邻节点入度减1，再重复该过程
        Queue< Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
        	if(in[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()) {
        	int vertex = queue.poll();
        	for(int adjcents:edges.get(vertex)) {
        		in[adjcents]--;
        		if(in[adjcents]==0) queue.add(adjcents);
        	}
        }
        //执行完上述操作后，只有环中节点入度才不为0，其余节点入度为0
        for(int i=0;i<numCourses;i++) {
        	if(in[i]!=0) return false;
        }
        return true;
    }
	//我的解法2（参照网上解法）——DFS检测有向环
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		int n = prerequisites.length;
		//visited数组中每个顶点有三种状态，未访问时状态为0，已经对该顶点进行DFS环检测，无环时表示为1，有环表示为-1.
		int[] visited = new int[numCourses];//0：未访问，1：不是环中顶点，-1：是环中顶点
        //生成邻接表,同时初始化入度数组
		List<ArrayList<Integer>> edges = new ArrayList<>();
		for(int i=0;i<numCourses;i++) {
			edges.add(new ArrayList<Integer>());
		}
        for(int i=0;i<n;i++) {
        	int left = prerequisites[i][0];
        	int right = prerequisites[i][1];
        	edges.get(left).add(right);//默认0指向1（左指向右）
        }
        for(int i=0;i<numCourses;i++) {
        	if(dfsFindCicle(edges, i, visited)) return false;
        }
        return true;
	}
	public boolean dfsFindCicle(List<ArrayList<Integer>> edges,int vertex,int[] visited) {
		if(visited[vertex]==-1) return true;
		if(visited[vertex]==1) return false;
		visited[vertex] = -1;
		for(int adjcents:edges.get(vertex)) {
			if(dfsFindCicle(edges, adjcents, visited)) return true;
		}
		visited[vertex] = 1;
		return false;
	}
	
	
	public static void main(String[] args) {
		int[][] prerequisites = {{0,1},{1,2},{2,3},{3,4}};
		CourseSchedule207 test = new CourseSchedule207();
		System.out.println(test.canFinish2(5, prerequisites));
	}
}
