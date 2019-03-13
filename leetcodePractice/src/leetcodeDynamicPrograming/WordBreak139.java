package leetcodeDynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak139 {
	//���Ͻⷨ���ݹ�+����¼/�������顣memo[i]��ʾ�ַ���s��[0,i)���Ӵ��Ƿ�����wordDict��
	//�ַ�����ɣ�memo[i]Ϊ0��ʾ���ܱ�ʾ��memo[i]Ϊ1��ʾ�ܱ�ʾ��memo[i]Ϊ-1��ʾû�����
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> workBank= new HashSet<>(wordDict);
        int n = s.length();
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return check(s, workBank, memo, 0);
    }
    //��start��ʼ���Ӵ��ܷ񱻲��
    public static boolean check(String s,HashSet<String> workBank,int[] memo,int start) {
		if(start>=s.length()) return true;
		if(memo[start]!=-1) {
			return memo[start]==0?false:true;
		}
		for(int i=start+1;i<=s.length();i++) {
			//��[start,i)�����Ӵ���wordBank���棬���Ҵ�[i,s.length)Ҳ�ǿ���wordBank�дʻ���
			//��
			if(workBank.contains(s.substring(start, i))&&check(s, workBank, memo, i)){
				memo[start] = 1;
				return true;
			}
		}
		memo[start] = 0;
		return false;
	}
 
    /*��̬�滮�����������Ͻⷨ��
     * ���Ǳ���Ҫ�������е��Ӵ���������j��[0, i)��Χ�ڵ��Ӵ���Ϊ�������֣�[0, j) �� [j, i)��
     * ���з�Χ [0, j) ����dp[j]����Χ [j, i) ����s.substr(j, i-j)������dp[j]��֮ǰ��״̬������
     * �Ѿ�������ˣ�����ֱ��ȡ��ֻ��Ҫ���ֵ��в���s.substr(j, i-j)�Ƿ�����ˣ��������
     * ��Ϊtrue����dp[i]��Ϊtrue������break������ʱ�Ͳ���Ҫ����jȥ��[0, i)��Χ�ˣ���Ϊ
     * [0, i)��Χ�Ѿ����Բ���ˡ�
     * */
    public static boolean wordBreak2(String s, List<String> wordDict) {
    	int n = s.length();
    	boolean[] dp = new boolean[n+1];
    	dp[0] = true;//����մ������
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
