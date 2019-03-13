package leetcodeTree;

import java.util.HashMap;

public class MapSumPairs677 {
	public static void main(String[] args) {
		MapSum obj = new MapSum();
		obj.insert("aa", 3);
		System.out.println(obj.sum("a"));
		obj.insert("aa", 2);
		System.out.println(obj.sum("a"));
	}
}
class MapSum {
	boolean isword;
	int value=0;
	HashMap<Character,MapSum> nexts;
    /** Initialize your data structure here. */
    public MapSum() {
        nexts = new HashMap<Character,MapSum>();
    }
    
    public void insert(String key, int val) {
    	boolean existed = this.search(key);//该key是否已经存在
        MapSum node = this;
        for(int i=0;i<key.length();i++) {
        	if(node.nexts.get(key.charAt(i))==null) {
        		node.nexts.put(key.charAt(i), new MapSum());
        	}	
        	node = node.nexts.get(key.charAt(i));
        	if(existed) node.value = val;
        	else node.value += val;
        }
        node.isword = true;
    }
    
    public int sum(String prefix) {
    	MapSum node = this;
    	for(int i=0;i<prefix.length();i++) {
    		if(node.nexts.get(prefix.charAt(i))==null) return 0;
    		node = node.nexts.get(prefix.charAt(i));
    	}
    	return node.value;
    }
    
    public boolean search(String word) {
        MapSum node = this;
        for(int i=0;i<word.length();i++) {
        	if(node.nexts.get(word.charAt(i))==null) return false;
        	node = node.nexts.get(word.charAt(i));
        }
        return node.isword;
    }
}
