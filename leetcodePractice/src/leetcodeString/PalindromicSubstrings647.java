package leetcodeString;

public class PalindromicSubstrings647 {
	//参考作者解法
    public int countSubstrings(String s) {
    	int cnt=0;
        for(int i=0;i<s.length();i++) {
        	cnt += extendSubString(s, i, i) + extendSubString(s, i, i+1);
        }
        return cnt;
    }
    public int extendSubString(String s,int start,int end) {
    	int cnt = 0;
    	while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)) {
    		cnt++;
    		start--;
    		end++;
    	}
    	return cnt;
    }
}
