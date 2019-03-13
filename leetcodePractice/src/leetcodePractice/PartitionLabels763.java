package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {
	//̰�Ĳ��ԣ�������Ҫһ������last��¼��ǰ�ַ���iλ�ã����ַ���S�������ֵ�λ�ã�jλ�ã�����ô��������
	//��СΪ[i,j]��������������һ�ַ���������λ�ã�k������j����ǰ����������չΪ[i,k]����i�ƶ��������βj����
	//i==j����û���������������䳤�ȼ�����С�������䳤���б�ans��
	//***�������������ڣ��㷨ִ��֮ǰ����һ������õ����ڼ�¼ÿ���ַ�������λ�õ����飬������ִ���㷨����
	//***�з��������ַ�������S���ҵ����һ�γ���λ�á�
	public static List<Integer> partitionLabels(String S) {
        //һ�������¼�ַ���S��ÿ���ַ�������λ�ã���¼������last��
		int[] last = new int[26];
		for(int i=0;i<S.length();i++) {
			last[S.charAt(i)-'a'] = i; //��ʾ��Ļ'a-z'���ַ���S�������ֵ�λ�ã���ÿ���ַ�ֻ��һ��λ��ֵ
		}
		
		List<Integer> num = new ArrayList<>();
		int j = 0;
		int start = 0;
		for(int i = 0;i<S.length();i++) {
			j = Math.max(j, last[S.charAt(i)-'a']) ;
			if(i == j) {
				num.add(j - start +1);
				start = j+1;
			}
		}
		return num;
    }
	
	public static void main(String[] args) {
		String string = "ababcbacadefegdehijhklij";
		List<Integer> num = partitionLabels(string);
		System.out.println(num.toString());
	}
}
