package leetcodeString;

public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        int[] cnt = new int[58];
        int longest = 0;
        for(int i=0;i<s.length();i++) {
        	cnt[s.charAt(i)-'A'] ++;
        }
        for(int each:cnt) {
        	longest += each/2;
        }
        if(longest*2 == s.length()) return longest*2;
        return longest*2+1;
    }
}
