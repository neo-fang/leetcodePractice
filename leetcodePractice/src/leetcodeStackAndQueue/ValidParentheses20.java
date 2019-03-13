package leetcodeStackAndQueue;

import java.util.Stack;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{') {
        		stack.push(s.charAt(i));
        	}else {
        		if(stack.isEmpty()) return false;//ÏÈ·ÅÓÒÀ¨ºÅ
        		char left = stack.pop();
        		if(left=='('&&s.charAt(i)==')'||left=='['&&s.charAt(i)==']'
        				||left=='{'&&s.charAt(i)=='}') {
        			continue;
        		}//×óÓÒÀ¨ºÅÀàÐÍÆ¥Åä
        		else return false;
        	}		
        }
        return stack.isEmpty();//Èç¹û×óÀ¨ºÅ¶àÓÚÓÒÀ¨ºÅ£¬²»Æ¥Åä
    }
    public static void main(String[] args) {
		String s = "[";
		ValidParentheses20 test = new ValidParentheses20();
		System.out.println(test.isValid(s));
	}
}
