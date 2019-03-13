package leetcodePractice;

import java.util.LinkedList;
import java.util.List;

public class DifferentWaystoAddParentheses241 {
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new LinkedList<>();//用于存放计算结果
        for(int i=0;i<input.length();i++) {
        	if(input.charAt(i) == '+'||input.charAt(i)=='-'||input.charAt(i)=='*') {//遇到计算符号
        		List<Integer> leftResSet = diffWaysToCompute(input.substring(0, i));//符号左边字符串计算结果集合
        		List<Integer> rightResSet = diffWaysToCompute(input.substring(i+1));//符号右边字符串计算结果结合
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
      //递归终止条件：输入input为数字时，直接返回数字
        if(ways.size()==0) ways.add(Integer.valueOf(input));
        return ways;
    }
    
    public static void main(String[] args) {
		String input = "2-1-1";
		System.out.println(diffWaysToCompute(input));
	}
    
}
