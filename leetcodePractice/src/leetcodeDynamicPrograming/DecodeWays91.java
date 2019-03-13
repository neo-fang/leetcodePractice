package leetcodeDynamicPrograming;

public class DecodeWays91 {
	//DFS
    public static int numDecodings(String s) {
    	if(s==null||s.contains("0")) return 0;
        if(s.length() == 1||s.length()==0) return 1;
        int tmp = Integer.parseInt(s.substring(0, 2));
        if(tmp<=26) {
        	int tmp1 = numDecodings(s.substring(1));
        	int tmp2 = numDecodings(s.substring(2));
        	return  tmp1 + tmp2;
        }else {
        	return numDecodings(s.substring(1));
        }
    }
    
    //参考解法（与爬楼梯的算法很类似，只是多了一些判断条件）
    public static int numDecodings2(String s) {
    	if (s.isEmpty() || s.charAt(0) == '0') return 0;
    	int prev = 0;
    	int cur = 1;
    	// 长度为n的字符串，有n+1个阶梯?我认为是n个阶梯
    	for (int i = 1; i <= s.length(); ++i) {
    		//下面三行用于处理出现'0'以及不可以超过26的规定的特殊情况（无法理解）
	    	if (s.charAt(i-1) == '0') cur = 0;//
	    	if (i < 2 || !(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')))//不理解
	    		prev = 0;//
	    	
	    	int tmp = cur;
	    	cur = prev + cur;
	    	prev = tmp;
    	}
    	return cur;
    }
    
    public static void main(String[] args) {
		String s = "263";
		System.out.println(numDecodings2(s));
	}

}
