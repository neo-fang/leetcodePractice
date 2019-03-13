package leetcodeMath;
//��a��b���Լ��
public class GcdLcm {
	/***************���Լ��gcd*******************/
	//�ҵĽⷨ����������
	public static int gcd(int a, int b) {
		int maxGcd = 1;
		for(int i=2;i<=Math.min(a, b);i++){
			if(a%i==0&&b%i==0) 	maxGcd = Math.max(maxGcd, i);
		}
		return maxGcd;
	}
	//���߽ⷨ���ݹ鷨������շת�����
	int gcd2(int a, int b) {
		if (a < b)   return gcd2(b, a);
	    return b == 0 ? a : gcd(b, a % b);
	}
	/***************��С������lcm*******************/
	//���ۣ���С������Ϊ�����ĳ˻��������Լ����
	int lcm(int a, int b) {
	    return a * b / gcd(a, b);
	}
	
	public static void main(String[] args) {
		GcdLcm gcdLcm = new GcdLcm();
		System.out.println(gcdLcm.gcd2(0, 4));
	}
}
