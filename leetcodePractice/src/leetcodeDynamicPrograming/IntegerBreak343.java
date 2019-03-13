package leetcodeDynamicPrograming;

public class IntegerBreak343 {
	//解法1：归纳法；算法：要是乘积最大，所有数必须2、3的组合，且3的数量尽可能最大，而且不包含1。
	//任何数除以3的余数有两种，余数为1，余数为2，由于1不能包含，因此加入两个2处理余数为1的情况，
	//余数为2时，直接加入2。因此乘积最大的组合中最多只包含两个2，其余全部为3.
    public static int integerBreak(int n) {
    	if(n == 0|| n==1) return 0;
    	if(n<4) return n-1;
    	 int numOf3;
    	 int numOf2;
    	 numOf3 = n%3==1?n/3-1:n/3;  	 
    	 numOf2 = (n-3*numOf3)/2;
    	 return (int) (Math.pow(3, numOf3) * Math.pow(2, numOf2));
    }
    
    //动态规划法
    public static int integerBreak2(int n) {
    	if(n == 0|| n==1) return 0;
    	if(n<4) return n-1;
    	int[] mul = {3,4,6};//保存n%3的余数为0，1，2的值，每层乘以3
    	for(int i=6;i<=n;i++) {
    		mul[i%3] = 3*mul[i%3];
    	}
    	return mul[n%3];
    }
    public static void main(String[] args) {
		int n = 11;
		System.out.println(integerBreak2(n));
	}
}
