package leetcodeMath;

public class PowerofThree326 {
	//我的解法1（超时）
    public static boolean isPowerOfThree(int n) {
    	int i = 1;
        while(i<n) {
        	i *= 3;
        }
        return i==n;
    }
    //作者解法：由于输入是int，正数范围是0-2^31，在此范围中允许的最大的3的次方数为319=1162261467，那么我们只要看这个数能否被n整除即可
	public boolean isPowerOfThree2(int n) {
	    return n > 0 && (1162261467 % n == 0);
	}
    public static void main(String[] args) {
		System.out.println(isPowerOfThree(1));
	}
}
