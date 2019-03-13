package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber17 {
	private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
    	List<String> output = new ArrayList<>();
    	if(digits == null||digits.length() == 0) return output;
    	int num = digits.charAt(0) - '0';
    	if(digits.length() == 1) {
    		for(int i=0;i<KEYS[num].length();i++) {
        		output.add(String.valueOf(KEYS[num].charAt(i)));
        	}
    		return output;
    	}
    	List<String> restString = letterCombinations(digits.substring(1));
    	for(int i=0;i<KEYS[num].length();i++) {
    		for(String rest:restString) {
    			output.add(KEYS[num].charAt(i)+rest);
    		}
    	}
    	return output;
    }
    
    public static void main(String[] args) {
    	String digits = "234";
    	System.out.println(letterCombinations(digits).toString());
    	}
    
}
