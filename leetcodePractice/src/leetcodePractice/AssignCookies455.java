package leetcodePractice;

import java.util.Arrays;

public class AssignCookies455 {
	public static int findContentChildren(int[] g, int[] s) {
		//对需求数组和供应数组分别从小到大排序
        Arrays.sort(g);
        Arrays.sort(s);
        int curChild = 0;
        int curCookie = 0;
        int fitNum = 0;
        //贪心策略：每次从需求数组中取出最小的需求，然后从供应数组取出最小可以满足的s，直到其中一个数组到达末尾
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
