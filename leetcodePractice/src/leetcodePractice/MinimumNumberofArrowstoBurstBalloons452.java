package leetcodePractice;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons452 {
	//��������Ŀ435�����ǳ����ƣ�ֻ��̰�Ĳ��Եı�׼���иı�
	//̰�Ĳ��ԣ�ÿ��ȡ��start����ģ�endȡ�������endֵ������ص�����endֵ�е���Сֵ��
	//�ص����ж�����next->start>minend
	public static int findMinArrowShots(int[][] points) {
		if(points == null||points.length<1) return 0;
		Arrays.sort(points, Comparator.comparingInt(o->o[0]));
		int end = points[0][1]; 
		int count = 1;
		for(int i=1;i<points.length;i++) {
			if(points[i][0]<=end) {
				end = end<points[i][1]?end:points[i][1];
				continue;
			}
			end = points[i][1];
			count++;
		}
		return count;
    }
	
	public static void main(String[] args) {
		//int[][] points ={{10,16}, {2,8}, {1,6}, {7,12}};
		//int[][] points = {{1,2},{2,3},{3,4},{4,5}};
		int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
		//System.out.println(Arrays.toString(arr[2]));
		System.out.println(findMinArrowShots(points));
	}
}
