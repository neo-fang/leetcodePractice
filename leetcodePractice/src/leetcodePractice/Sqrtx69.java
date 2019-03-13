package leetcodePractice;

public class Sqrtx69 {
//������һ���ӣ���m*mֵ����int���ͽ��ܷ�Χʱ�����Զ��е������Ĳ��֣����½���������
//��Ҫǿ������ת��Ϊlong���ͣ���֤���������
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
	return m;//���㷨��m����ֵ��ԶС�ڵ���key
    }

	public static void main(String[] args) {
		System.out.println(mySqrt(2147395599));
	}
}
