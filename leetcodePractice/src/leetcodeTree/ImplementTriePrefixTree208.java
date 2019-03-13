package leetcodeTree;

import java.util.HashMap;

public class ImplementTriePrefixTree208 {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
	}
}
class Trie {
	boolean isword;//是否是单词结尾
	HashMap<Character, Trie> nexts;
    /** Initialize your data structure here. */
    public Trie() {
       nexts = new HashMap<Character, Trie>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	Trie node = this;
        for(int i=0;i<word.length();i++) {
        	if(node.nexts.get(word.charAt(i))==null) {
        		node.nexts.put(word.charAt(i), new Trie());
        	}
        	node = node.nexts.get(word.charAt(i));
        }
        node.isword = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for(int i=0;i<word.length();i++) {
        	if(node.nexts.get(word.charAt(i))==null) return false;
        	node = node.nexts.get(word.charAt(i));
        }
        return node.isword;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for(int i=0;i<prefix.length();i++) {
        	if(node.nexts.get(prefix.charAt(i))==null) return false;
        	node = node.nexts.get(prefix.charAt(i));
        }
        return true;
    }
}
