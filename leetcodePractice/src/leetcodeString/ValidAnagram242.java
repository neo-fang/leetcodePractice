package leetcodeString;

import java.util.ArrayList;
import java.util.List;

public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        List<Character> list = new ArrayList<>();
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++) {
        	list.add(s.charAt(i));
        }
        for(char each:t.toCharArray()) {   	
        	if(!list.contains(each))  return false;
        		list.remove(list.indexOf(each));
        }
        return true;
    }
    public static void main(String[] args) {
    	String s = "anagraa";
    	String t = "nagaram";
    	ValidAnagram242 test = new ValidAnagram242();
    	System.out.println(test.isAnagram(s, t));
	}
}
