package leetcodePractice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency451 {
	//此题跟对数组中数字按照频率大小输出（题目347）一样，只是在输出时重复元素也要加入而已
			  //public List<Integer> topKFrequent(int[] nums, int k) {
		public static class FrequencyNode{
			int frequency;
			char chars;
			public FrequencyNode(char chars,int frequency) {
				this.frequency = frequency;
				this.chars = chars;
			}
		}
				
			public static class FreComparator implements Comparator<FrequencyNode>{
				@Override
				public int compare(FrequencyNode o1, FrequencyNode o2) {
					return o2.frequency - o1.frequency;//实现大根堆
				}
			}

			public static String frequencySort(String s) {
				char[] chars = s.toCharArray();
			    // build hash map : character and how often it appears
			    HashMap<Character, Integer> count = new HashMap<Character, Integer>();
			    for (char n: chars) {
			      count.put(n, count.getOrDefault(n, 0) + 1);
			    }
			    // init heap 'the less frequent element first'
			    PriorityQueue<FrequencyNode> heap =
			            new PriorityQueue<FrequencyNode>(new FreComparator());//大根堆

			    // keep k top frequent elements in the heap
			    for (char n: count.keySet()) {
			    	heap.add(new FrequencyNode(n, count.get(n)));
			    }
			    //生成最后的输出字符串
			    StringBuilder output = new StringBuilder();
			    while(!heap.isEmpty()) {
			    	//output = output + heap.poll().chars*heap.poll().frequency;
			    	FrequencyNode tmp = heap.poll();
			    	for(int i =0;i<tmp.frequency;i++) {
			    		output.append(tmp.chars);
			    	}
			    }
			    return output.toString();
			 }
		
		public static void main(String[] args) {
			String Input = 	"treerr";
			System.out.println(frequencySort(Input));

		}
}
