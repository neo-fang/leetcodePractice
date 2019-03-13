package leetcodeGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII210 {
	//�ҵĽⷨ���������㷨
    public int[] findOrder(int numCourses, int[][] prerequisites) {
		int n = prerequisites.length;
		List<Integer> order = new ArrayList<>();
        //�����ڽӱ�,ͬʱ��ʼ���������
		List<ArrayList<Integer>> edges = new ArrayList<>();
		for(int i=0;i<numCourses;i++) {
			edges.add(new ArrayList<Integer>());
		}
		int[] in = new int[numCourses];
        for(int i=0;i<n;i++) {
        	int left = prerequisites[i][0];
        	int right = prerequisites[i][1];
        	edges.get(right).add(left);//Ĭ��1ָ��0����ָ���󣩣��ұ�Ϊ���޿γ�
        	in[left]++;
        }
        //�����Ϊ0�Ķ���ѹջ��ȡ��ջ��ÿ������ɾ���������ڽڵ���ȼ�1�����ظ��ù���
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
