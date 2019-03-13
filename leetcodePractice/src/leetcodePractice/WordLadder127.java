package leetcodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)||beginWord.equals(endWord)) return 0;
        Queue<String> wordQueue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<>();
        int level = 0;
        wordQueue.add(endWord);
        visited.add(endWord);
        while(!wordQueue.isEmpty()){
        	level ++;
        	int size = wordQueue.size();
        	while(size-->0) {
        		String cur = wordQueue.poll();
        		//if(cur.compareTo(beginWord)==0) return level;
        		if(isConnected(cur,beginWord)) return level+1;//该字符串转化为目的字符串还需要一次转换，即是否在图中相互连接
        		for(String s:wordList) { 			
        			if(visited.contains(s)) continue;
        			if(isConnected(cur,s)) {
        				wordQueue.add(s);
        				visited.add(s);
        			}
        		}
        	}
        }
        return 0;
    }
    public static boolean isConnected(String s1,String s2) {
		int dif = 0;
		for(int i =0;i<s1.length();i++) {
			if(s1.charAt(i)!=s2.charAt(i)) dif++;
		}
		return dif == 1;
	}
    
    public static void main(String[] args) {
    	String beginWord = "hit";
    	String endWord = "cog";
    	List<String> wordList = new ArrayList<>(Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})) ;
    	System.out.println(ladderLength(beginWord, endWord, wordList));
	}
    
}
