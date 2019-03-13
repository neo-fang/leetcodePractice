package leetcodeString;

import java.util.HashMap;

public class IsomorphicStrings205 {
    public boolean isIsomorphic(String s, String t) {
    	int m = s.length();
    	int n = t.length();
    	if(m!=n) return false;
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for(int i=0;i<m;i++) {
        	if(map1.containsKey(s.charAt(i))){
        		if(map1.get(s.charAt(i))!=t.charAt(i)) return false; 
        	}
        	if(map2.containsKey(t.charAt(i))) {
        		if(map2.get(t.charAt(i))!=s.charAt(i)) return false;
        	}
        	map1.put(s.charAt(i), t.charAt(i));
        	map2.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
}
