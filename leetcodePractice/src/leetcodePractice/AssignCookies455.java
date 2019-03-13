package leetcodePractice;

import java.util.Arrays;

public class AssignCookies455 {
	public static int findContentChildren(int[] g, int[] s) {
		//����������͹�Ӧ����ֱ��С��������
        Arrays.sort(g);
        Arrays.sort(s);
        int curChild = 0;
        int curCookie = 0;
        int fitNum = 0;
        //̰�Ĳ��ԣ�ÿ�δ�����������ȡ����С������Ȼ��ӹ�Ӧ����ȡ����С���������s��ֱ������һ�����鵽��ĩβ
        for(;curChild<g.length;curChild++) {
        	while(curCookie<s.length&&s[curCookie]<g[curChild]) curCookie++;
        	if(curCookie<s.length) {
        		fitNum++;
        		curCookie++;
        	}else return fitNum;
        }
        return fitNum;
    }
	public static void main(String[] args) {
		int[] g = {4,3};
		int[] s = {2,4};
		System.out.println(findContentChildren(g, s));
	}
	
}
