package leetcodePractice;

import java.util.Arrays;
import java.util.Comparator;

//����������㷨�еĻ����Ұ�������һ����ÿ�����������鿪ʼʱ��ͽ���ʱ��
//Ӧ������̰�Ĳ��ԣ����Ȱ��Ų��ص��ҽ���ʱ����������䣬Ȼ�󽫴�����ȥ����ѡ����һ������
public class NonoverlappingIntervals435 {
	public static class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
	
	public static class IntervalComparator implements Comparator<Interval>{
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.end - o2.end;
		}
	}
	
	public static int eraseOverlapIntervals(Interval[] intervals) {
        int endTime = Integer.MIN_VALUE;
        int count = 0;
        Arrays.sort(intervals, new IntervalComparator());
       for(int i=0;i<intervals.length;i++) {
    	   if(intervals[i].start>=endTime) {
    		   endTime = intervals[i].end;
    		   count++;
    	   }
       }
       return intervals.length-count;
    }
	public static void main(String[] args) {
		//[[1,2],[2,3],[3,4],[-100,-2],[5,7]]
		Interval[] intervals = {new Interval(1, 2),new Interval(2, 3),new Interval(3, 4),new Interval(-100, -2),new Interval(5, 7)};
		//Interval[] intervals = {new Interval(1, 2),new Interval(2, 3),
				//new Interval(3, 4),new Interval(1, 3)};
		//Interval[] intervals = {new Interval(1, 2),new Interval(2, 3),new Interval(1, 2)};
		System.out.println(eraseOverlapIntervals(intervals));
	}
}
