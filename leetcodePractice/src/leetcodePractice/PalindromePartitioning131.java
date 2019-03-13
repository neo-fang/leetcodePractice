package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {
    public static List<List<String>> partition(String s) {
    	List<List<String>> finalList = new ArrayList<>();
    	//doPartition(s, 0, 0,finalList, new ArrayList<String>());
    	doPartition2(s, finalList, new ArrayList<String>());
    	return finalList;
    }
    //�ҵĽⷨ1����ʱ��
    //�������ַ���������������
    public static void doPartition(String s,int start,int listLen,List<List<String>> finalList,List<String> tmpList) {
		if(start==s.length()&&listLen==s.length()) {
			finalList.add(new ArrayList<>(tmpList));
			return ;
		}
		for(int i = start;i<s.length();i++) {//��ѭ�������ֻ��Ҫ����һ�Σ���i=0���ɣ����涼û��Ҫ
			//if(i!=0&&tmpList.isEmpty()) return;
			for(int j=i+1;j<=s.length();j++) {
				if(!isPalindrome(s.substring(i, j))) continue;
				String tmp = s.substring(i, j);
				tmpList.add(tmp);
				listLen += tmp.length(); 
				doPartition(s, j,listLen,finalList, tmpList);
				tmpList.remove(tmpList.size()-1);
				listLen-= tmp.length();
			}
		}
	}

    public static boolean isPalindrome(String s) {//�ж��ַ����Ƿ��ǻ����ַ���
    	if(s==null||s.length()==0) return false;
    	int start = 0;
    	int end = s.length()-1;
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
    
    //�������߽ⷨ�Ľⷨ
    public static void doPartition2(String s,List<List<String>> finalList,List<String> tmpList) {
		if(s==null||s.length()==0) {
			finalList.add(new ArrayList<>(tmpList));
			return ;
		}
		for(int i=0;i<s.length();i++) {
			if(isPalindrome2(s, 0, i)) {
				tmpList.add(s.substring(0, i+1));
				doPartition2(s.substring(i+1),finalList, tmpList);
				tmpList.remove(tmpList.size()-1);
			}
		}
    }
    
    public static boolean isPalindrome2(String s,int start,int end) {//�ж��ַ����Ƿ��ǻ����ַ���
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
    
    public static void main(String[] args) {
		String s = "bab";
		//System.out.println(isPalindrome(s));
		System.out.println(partition(s));
	}
}
