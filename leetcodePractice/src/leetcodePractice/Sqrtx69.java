package leetcodePractice;

public class Sqrtx69 {
//本题有一个坑：当m*m值超出int类型接受范围时，会自动切掉超出的部分，导致结果错误，因此
//需要强制类型转换为long类型，保证不会溢出。
public static int mySqrt(int x) {
	int l = 0;
	int r = x/2+1;
	int m = (l+r)/2;
	while(l<=r) {
		if((long)m*m == x) {
			return (int)m;
		}else if((long)m*m<x) {
			l = m + 1;
		}else {
			r = m - 1;
		}
		m = (l + r)/2;
	}
	return m;//该算法中m处的值永远小于等于key
    }

	public static void main(String[] args) {
		System.out.println(mySqrt(2147395599));
	}
}
