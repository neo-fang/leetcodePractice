package leetcodePractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements347 {
	public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numFrequence = new HashMap<>();
        for(Integer num : nums) {
        	numFrequence.put(num, numFrequence.getOrDefault(num,0)+1);
        }
        
        List<Integer>[] bucket = new ArrayList[nums.length+1];//若数组中数字全部相同，则长度为nums.length不够，因为最大频率也为nums.length，会出现数组越界
        for(Integer num : numFrequence.keySet()) {
        	if(bucket[numFrequence.get(num)] == null) {
        		bucket[numFrequence.get(num)] = new ArrayList<Integer>();
        	}
        	bucket[numFrequence.get(num)].add(num);
        }
        List<Integer> topK = new ArrayList<Integer>();
        for(int i=bucket.length-1; i>0&&topK.size()<k;i--) {
        	if(bucket[i]!=null) {
        		for(int tmp : bucket[i]) {
        				if(topK.size()<k) {
        					topK.add(tmp);
        				}
        		}
        		}
        	}
        return topK;
        }
	
	/*作者解法，错误，但是Leetcode没有检测出来，错误之处见下面*/
	public static List<Integer> topKFrequent2(int[] nums, int k) {
	    Map<Integer, Integer> frequencyForNum = new HashMap<>();
	    for (int num : nums) {
	        frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
	    }
	    List<Integer>[] buckets = new ArrayList[nums.length + 1];
	    for (int key : frequencyForNum.keySet()) {
	        int frequency = frequencyForNum.get(key);
	        if (buckets[frequency] == null) {
	            buckets[frequency] = new ArrayList<>();
	        }
	        buckets[frequency].add(key);
	    }
	    List<Integer> topK = new ArrayList<>();
	    for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
	        if (buckets[i] != null) {
	            topK.addAll(buckets[i]);//此处直接把相同的频率中所有的数字都加入topK，而忽略了全部加入可能会是总量大于k
	        }
	    }
	    return topK;
	}
	
	/*我的解法——利用堆*/
	public static class FrequencyNode{
		int frequency;
		int num;
		public FrequencyNode(int num,int frequency) {
			this.frequency = frequency;
			this.num = num;
		}
	}
	
	public static class FreComparator implements Comparator<FrequencyNode>{
		@Override
		public int compare(FrequencyNode o1, FrequencyNode o2) {
			return o1.frequency - o2.frequency;
		}
	}
	
	public static List<Integer> topKFrequent3(int[] nums, int k) {
		//统计每个数字出现的频率
		HashMap<Integer, Integer> numFrequency = new HashMap<>();
		for(int num: nums) {
			numFrequency.put(num, numFrequency.getOrDefault(num, 0)+1);
		}
		PriorityQueue<FrequencyNode> frequencyNodes = new PriorityQueue<>(new FreComparator());
		for(int num : numFrequency.keySet()) {
			frequencyNodes.add(new FrequencyNode(num, numFrequency.get(num)));
			if(frequencyNodes.size()>k) {
				frequencyNodes.poll();
			}
		}
		List<Integer> topK = new ArrayList<>();
		for(FrequencyNode tmp:frequencyNodes) {
			topK.add(tmp.num);
		}
		return topK;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,2,3,3,4,4,4,4};
		int k =2;
		System.out.println(topKFrequent(nums, k));
		System.out.println(topKFrequent2(nums, k));
		System.out.println(topKFrequent3(nums, k));
	}
 }
