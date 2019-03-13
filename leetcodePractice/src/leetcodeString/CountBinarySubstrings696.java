package leetcodeString;

public class CountBinarySubstrings696 {
	//我的解法（存在大量重复操作，相邻连续长度的计算重复）：判断以每个元素为开头的子串是否符合条件
    public int countBinarySubstrings(String s) {
    	int cnt = 0;
        for(int i=0;i<s.length();i++) {
        	if(validNum(s, i)) cnt++;
        }
        return cnt;
    }
    public boolean validNum(String s,int left) {
    	int n = s.length();
    	int right = left+1;
    	while(right<n&&s.charAt(right)==s.charAt(right-1)) right++;
    	int len = right - left;
    	int i=0;
    	for(;right<n&&i<len;i++,right++) {
    		if(s.charAt(right)==s.charAt(left)) return false;
    	}
    	return i==len;
	}
    
    public static void main(String[] args) {
		String s = "10101";
		CountBinarySubstrings696 test = new CountBinarySubstrings696();
		System.out.println(test.countBinarySubstrings(s));
	}
}
