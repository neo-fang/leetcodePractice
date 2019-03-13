package leetcodePractice;

public class ValidPalindromeII680 {
/**
 * 我的解法（错误）
 * @param s
 * @return
 */
public static boolean myValidPalindrome(String s) {
        int header = 0;
        int tail = s.length() - 1;
        int deleteNum = 0;
        while(header<tail) {
        	if(deleteNum>1) return false;
        	if(s.charAt(header)==s.charAt(tail)) {
        		header++;
        		tail--;
        	}else {
        		deleteNum++;
        		if(s.charAt(header+1)==s.charAt(tail)&&header+2<=tail-1&&s.charAt(header+2)==s.charAt(tail-1)) {
        				header++;		
        		}else if(s.charAt(header)==s.charAt(tail-1)) {
					tail--;
				}else {
					return false;
				}
        	}
        }
        return true;
    }

/**
 * 正确解法
 * @param args
 */
public static boolean trueValidPalindrome(String s) {
	 int header = 0;
     int tail = s.length() - 1;
     while(header<tail) {
    	 if(s.charAt(header)!=s.charAt(tail)) {
    		 return isRestValid(header+1,tail, s)||isRestValid(header, tail-1, s);
    	 }
    	 header++;
    	 tail--;
     }
     return true;
}

public static boolean isRestValid(int start,int end, String s) {
	while(start<end) {
		if(s.charAt(start)!=s.charAt(end)) return false;
		start++;
		end--;
	}
	return true;
}
public static void main(String[] args) {
	//String s1 = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuclmgmqfvnbgtapekouga"; 
	String s2 = "abc"; 
	String s3 = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
	System.out.println("s2: "+trueValidPalindrome(s2));
	System.out.println("s3: "+trueValidPalindrome(s3));
}
}
