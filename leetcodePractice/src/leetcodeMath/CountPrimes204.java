package leetcodeMath;

import java.util.Arrays;

public class CountPrimes204 {
	//我的解法（超时）：对每个数都判断其是否为素数，计算量太大
    public int countPrimes(int n) {
    	int count = 0;
        for(int i = 2;i<n;i++) {
        	if(isPrime(i))	count += 1;
        }
        return count;
    }
    public  boolean isPrime(int num) {
    	if(num<2) return false;
		for(int i=2;i<=num/2;i++) {
			if(num%i==0) return false;
		}
		return true;
	}
    
    //我的解法（参考网上解法）——埃拉托斯特尼筛法
    public int countPrimes2(int n) {
    	int count = 0;
    	boolean[] notAPrime = new boolean[n];
    	//Arrays.fill(notAPrime, true);
    	for(int i=2;i<Math.sqrt(n);i++) {
    		if(!notAPrime[i]&&isPrime(i)) {//当前数是素数或者为判断
    			for(int j = 2;i*j<n;j++) {
    				notAPrime[i*j] = true;
    			}
    		}
    	}
    	for(int i=2;i<n;i++) {
    		if(!notAPrime[i]) count++;
    	}
    	return count;
    }
     //网上解法（更加精炼高效）
    public int countPrimes3(int n) {
    int res = 0;
    boolean[] prime = new boolean[n];
    Arrays.fill(prime, true);
  //按照从小到大的顺序，所有的合数都被标记为false，当遍历到i时，若i为合数,prime[i]已经被标记为false了
    for (int i = 2; i < n; ++i) {
        if (prime[i]) {
            ++res;
            for (int j = 2; i * j < n; ++j) {
                prime[i * j] = false;
            }
        }
    }
    return res;
}

    
    public static void main(String[] args) {
		CountPrimes204 test = new CountPrimes204();
		System.out.println(test.countPrimes3(12));
	}
}
