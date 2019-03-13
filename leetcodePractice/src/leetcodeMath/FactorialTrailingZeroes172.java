package leetcodeMath;

public class FactorialTrailingZeroes172 {
    public int trailingZeroes(int n) {
    	if(n<0) return 0;
        //¼ÆËã½×³Ë
    	//int fact=1;
    	long fact = 1;
    	int numOfZeros = 0;
    	if(n==0||n==1) fact = 1;
    	for(int i=2;i<=n;i++) {
    		fact = fact * i;
    	}
    	while(fact%10==0) {
    		numOfZeros++;
    		fact /= 10;
    	}
    	return numOfZeros;
    }
    
    public int trailingZeroes2(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
    
    public static void main(String[] args) {
		FactorialTrailingZeroes172 test = new FactorialTrailingZeroes172();
		System.out.println(test.trailingZeroes(13));
	}
}
