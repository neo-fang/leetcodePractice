package leetcodeMath;

public class PowerofThree326 {
	//�ҵĽⷨ1����ʱ��
    public static boolean isPowerOfThree(int n) {
    	int i = 1;
        while(i<n) {
        	i *= 3;
        }
        return i==n;
    }
    //���߽ⷨ������������int��������Χ��0-2^31���ڴ˷�Χ�����������3�Ĵη���Ϊ319=1162261467����ô����ֻҪ��������ܷ�n��������
	public boolean isPowerOfThree2(int n) {
	    return n > 0 && (1162261467 % n == 0);
	}
    public static void main(String[] args) {
		System.out.println(isPowerOfThree(1));
	}
}
