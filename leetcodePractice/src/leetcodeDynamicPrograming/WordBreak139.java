package leetcodeDynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak139 {
	//网上解法：递归+备忘录/记忆数组。memo[i]表示字符串s的[0,i)的子串是否能由wordDict中
	//字符串组成，memo[i]为0表示不能表示，memo[i]为1表示能表示，memo[i]为-1表示没计算过
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> workBank= new HashSet<>(wordDict);
        int n = s.length();
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return check(s, workBank, memo, 0);
    }
    //从start开始的子串能否被拆分
    public static boolean check(String s,HashSet<String> workBank,int[] memo,int start) {
		if(start>=s.length()) return true;
		if(memo[start]!=-1) {
			return memo[start]==0?false:true;
		}
		for(int i=start+1;i<=s.length();i++) {
			//若[start,i)部分子串在wordBank里面，而且从[i,s.length)也是可由wordBank中词汇拆分
			//则
			if(workBank.contains(s.substring(start, i))&&check(s, workBank, memo, i)){
				memo[start] = 1;
				return true;
			}
		}
		memo[start] = 0;
		return false;
	}
 
    /*动态规划法（参照网上解法）
     * 我们必须要遍历所有的子串，我们用j把[0, i)范围内的子串分为了两部分，[0, j) 和 [j, i)，
     * 其中范围 [0, j) 就是dp[j]，范围 [j, i) 就是s.substr(j, i-j)，其中dp[j]是之前的状态，我们
     * 已经算出来了，可以直接取，只需要在字典中查找s.substr(j, i-j)是否存在了，如果二者
     * 均为true，将dp[i]赋为true，并且break掉，此时就不需要再用j去分[0, i)范围了，因为
     * [0, i)范围已经可以拆分了。
     * */
    public static boolean wordBreak2(String s, List<String> wordDict) {
    	int n = s.length();
    	boolean[] dp = new boolean[n+1];
    	dp[0] = true;//处理空串的情况
    	for(int i=1;i<=n;i++) {
    		for(int j=0;j<i;j++) {
    			if(dp[j]&&wordDict.contains(s.substring(j, i))) {
    				dp[i] = true;
    				break;
    			}
    		}
    	}
    	return dp[n];
    }
    
    public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(wordBreak2(s, wordDict));
	}
}
