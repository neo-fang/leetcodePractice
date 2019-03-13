package leetcodePractice;

public class IsSubsequence392 {
	//本题是题目524其中一个小的实现函数
	public boolean isSubsequence(String s, String t) {
	     if(s.length() == 0) return true;
	     if(t.length() == 0) return false;
	        int i =0;
	        int j = 0;
	        for(;i<t.length()&&j<s.length();i++) {
	        	if(t.charAt(i) == s.charAt(j)) j++;
	        }
	        return j == s.length();
	    }
}
