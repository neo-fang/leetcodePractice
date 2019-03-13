package leetcodeMath;

import java.util.Arrays;

public class CountPrimes204 {
	//�ҵĽⷨ����ʱ������ÿ�������ж����Ƿ�Ϊ������������̫��
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
    
    //�ҵĽⷨ���ο����Ͻⷨ������������˹����ɸ��
    public int countPrimes2(int n) {
    	int count = 0;
    	boolean[] notAPrime = new boolean[n];
    	//Arrays.fill(notAPrime, true);
    	for(int i=2;i<Math.sqrt(n);i++) {
    		if(!notAPrime[i]&&isPrime(i)) {//��ǰ������������Ϊ�ж�
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
     //���Ͻⷨ�����Ӿ�����Ч��
    public int countPrimes3(int n) {
    int res = 0;
    boolean[] prime = new boolean[n];
    Arrays.fill(prime, true);
  //���մ�С�����˳�����еĺ����������Ϊfalse����������iʱ����iΪ����,prime[i]�Ѿ������Ϊfalse��
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
