package leetcodePractice;

public class ClimbingStairs70 {
	//递归解法
	static int waysNum = 0;
    public static int climbStairs(int n) {
    	if(n<0) return 0;
    	if(n == 0) {
			waysNum++;
			return waysNum;
		}
		climbStairs(n-1);//爬一步
		climbStairs(n-2);//爬两步
		return waysNum;
	}
    
    //动态规划解法(归纳法)
    public static int climbStairs2(int n) {
    	if(n<=2) return n;
    	int pre1 = 1;//
    	int pre2 = 2;
    	int cur = pre1 + pre2;
    	for(int i=3;i<=n;i++) {
    		cur = pre1 + pre2;
    		pre1 = pre2;
    		pre2 = cur;
    	}
    	return cur;
    }
    public static void main(String[] args) {
		int n =5;
		System.out.println(climbStairs2(n));
	}
}
