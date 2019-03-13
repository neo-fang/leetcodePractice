package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {
	//贪心策略：首先需要一个数组last记录当前字符（i位置）在字符串S中最后出现的位置（j位置），那么划分区间
	//最小为[i,j]，若该区间中任一字符的最后出现位置（k）大于j，则当前划分区间扩展为[i,k]，若i移动到区间结尾j，即
	//i==j，则该划分区间结束，将其长度加入最小划分区间长度列表ans。
	//***最巧妙的设计在于：算法执行之前，先一遍遍历得到用于记录每个字符最后出现位置的数组，避免了执行算法过程
	//***中反复遍历字符串数组S来找到最后一次出现位置。
	public static List<Integer> partitionLabels(String S) {
        //一遍遍历记录字符串S中每个字符最后出现位置，记录在数组last中
		int[] last = new int[26];
		for(int i=0;i<S.length();i++) {
			last[S.charAt(i)-'a'] = i; //表示字幕'a-z'在字符串S中最后出现的位置，且每个字符只有一个位置值
		}
		
		List<Integer> num = new ArrayList<>();
		int j = 0;
		int start = 0;
		for(int i = 0;i<S.length();i++) {
			j = Math.max(j, last[S.charAt(i)-'a']) ;
			if(i == j) {
				num.add(j - start +1);
				start = j+1;
			}
		}
		return num;
    }
	
	public static void main(String[] args) {
		String string = "ababcbacadefegdehijhklij";
		List<Integer> num = partitionLabels(string);
		System.out.println(num.toString());
	}
}
