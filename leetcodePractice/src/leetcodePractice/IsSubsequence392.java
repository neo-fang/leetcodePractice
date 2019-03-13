package leetcodePractice;

public class IsSubsequence392 {
	//��������Ŀ524����һ��С��ʵ�ֺ���
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
