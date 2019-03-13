package leetcodeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule207 {
	//�ⷨ1���������㷨��
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int n = prerequisites.length;
        //�����ڽӱ�,ͬʱ��ʼ���������
		List<ArrayList<Integer>> edges = new ArrayList<>();
		for(int i=0;i<numCourses;i++) {
			edges.add(new ArrayList<Integer>());
		}
		//List<Integer>[] edges = new List[numCourses];
		int[] in = new int[numCourses];
        for(int i=0;i<n;i++) {
        	int left = prerequisites[i][0];
        	int right = prerequisites[i][1];
        	edges.get(left).add(right);//Ĭ��0ָ��1����ָ���ң�
        	in[right]++;
        }
        //�����Ϊ0�Ķ���ѹջ��ȡ��ջ��ÿ������ɾ���������ڽڵ���ȼ�1�����ظ��ù���
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
        //ִ��������������ֻ�л��нڵ���ȲŲ�Ϊ0������ڵ����Ϊ0
        for(int i=0;i<numCourses;i++) {
        	if(in[i]!=0) return false;
        }
        return true;
    }
	//�ҵĽⷨ2���������Ͻⷨ������DFS�������
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		int n = prerequisites.length;
		//visited������ÿ������������״̬��δ����ʱ״̬Ϊ0���Ѿ��Ըö������DFS����⣬�޻�ʱ��ʾΪ1���л���ʾΪ-1.
		int[] visited = new int[numCourses];//0��δ���ʣ�1�����ǻ��ж��㣬-1���ǻ��ж���
        //�����ڽӱ�,ͬʱ��ʼ���������
		List<ArrayList<Integer>> edges = new ArrayList<>();
		for(int i=0;i<numCourses;i++) {
			edges.add(new ArrayList<Integer>());
		}
        for(int i=0;i<n;i++) {
        	int left = prerequisites[i][0];
        	int right = prerequisites[i][1];
        	edges.get(left).add(right);//Ĭ��0ָ��1����ָ���ң�
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
