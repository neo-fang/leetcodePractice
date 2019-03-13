package leetcodePractice;

import java.util.LinkedList;
import java.util.List;

public class DifferentWaystoAddParentheses241 {
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new LinkedList<>();//���ڴ�ż�����
        for(int i=0;i<input.length();i++) {
        	if(input.charAt(i) == '+'||input.charAt(i)=='-'||input.charAt(i)=='*') {//�����������
        		List<Integer> leftResSet = diffWaysToCompute(input.substring(0, i));//��������ַ�������������
        		List<Integer> rightResSet = diffWaysToCompute(input.substring(i+1));//�����ұ��ַ������������
        		for(int left:leftResSet) {
        			for(int right:rightResSet) {
        				switch (input.charAt(i)) {
						case '+':
							ways.add(left+right);
							break;
						case '-':
							ways.add(left-right);
							break;
						case '*':
							ways.add(left*right);
							break;
						}
        			}
        		}
        	}
        }
      //�ݹ���ֹ����������inputΪ����ʱ��ֱ�ӷ�������
        if(ways.size()==0) ways.add(Integer.valueOf(input));
        return ways;
    }
    
    public static void main(String[] args) {
		String input = "2-1-1";
		System.out.println(diffWaysToCompute(input));
	}
    
}
