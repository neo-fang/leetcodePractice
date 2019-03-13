package leetcodeGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII210 {
	//我的解法：秩排序算法
    public int[] findOrder(int numCourses, int[][] prerequisites) {
		int n = prerequisites.length;
		List<Integer> order = new ArrayList<>();
        //生成邻接表,同时初始化入度数组
		List<ArrayList<Integer>> edges = new ArrayList<>();
		for(int i=0;i<numCourses;i++) {
			edges.add(new ArrayList<Integer>());
		}
		int[] in = new int[numCourses];
        for(int i=0;i<n;i++) {
        	int left = prerequisites[i][0];
        	int right = prerequisites[i][1];
        	edges.get(right).add(left);//默认1指向0（右指向左），右边为先修课程
        	in[left]++;
        }
        //将入度为0的顶点压栈，取出栈中每个顶点删除，其相邻节点入度减1，再重复该过程
        Queue< Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
        	if(in[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()) {
        	int vertex = queue.poll();
        	order.add(vertex);
        	for(int adjcents:edges.get(vertex)) {
        		in[adjcents]--;
        		if(in[adjcents]==0) queue.add(adjcents);
        	}
        }
        if(order.size()!=numCourses) return new int[0];
        int[] res = new int[order.size()];
        for(int i=0;i<order.size();i++) {
        	res[i] = order.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
    	int[][] prerequisites = {{4,0},{1,3},{4,1},{2,4},{0,2}};
    	CourseScheduleII210 test = new CourseScheduleII210();
    	System.out.println(Arrays.toString(test.findOrder(5, prerequisites)));
	}
}
