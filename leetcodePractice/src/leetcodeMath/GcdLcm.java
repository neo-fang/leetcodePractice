package leetcodeMath;
//求a，b最大公约数
public class GcdLcm {
	/***************最大公约数gcd*******************/
	//我的解法（迭代法）
	public static int gcd(int a, int b) {
		int maxGcd = 1;
		for(int i=2;i<=Math.min(a, b);i++){
			if(a%i==0&&b%i==0) 	maxGcd = Math.max(maxGcd, i);
		}
		return maxGcd;
	}
	//作者解法（递归法）——辗转相除法
	int gcd2(int a, int b) {
		if (a < b)   return gcd2(b, a);
	    return b == 0 ? a : gcd(b, a % b);
	}
	/***************最小公倍数lcm*******************/
	//结论：最小公倍数为两数的乘积除以最大公约数。
	int lcm(int a, int b) {
	    return a * b / gcd(a, b);
	}
	
	public static void main(String[] args) {
		GcdLcm gcdLcm = new GcdLcm();
		System.out.println(gcdLcm.gcd2(0, 4));
	}
}
