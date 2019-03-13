package leetcodeDynamicPrograming;

public class IntegerBreak343 {
	//�ⷨ1�����ɷ����㷨��Ҫ�ǳ˻��������������2��3����ϣ���3��������������󣬶��Ҳ�����1��
	//�κ�������3�����������֣�����Ϊ1������Ϊ2������1���ܰ�������˼�������2��������Ϊ1�������
	//����Ϊ2ʱ��ֱ�Ӽ���2����˳˻�������������ֻ��������2������ȫ��Ϊ3.
    public static int integerBreak(int n) {
    	if(n == 0|| n==1) return 0;
    	if(n<4) return n-1;
    	 int numOf3;
    	 int numOf2;
    	 numOf3 = n%3==1?n/3-1:n/3;  	 
    	 numOf2 = (n-3*numOf3)/2;
    	 return (int) (Math.pow(3, numOf3) * Math.pow(2, numOf2));
    }
    
    //��̬�滮��
    public static int integerBreak2(int n) {
    	if(n == 0|| n==1) return 0;
    	if(n<4) return n-1;
    	int[] mul = {3,4,6};//����n%3������Ϊ0��1��2��ֵ��ÿ�����3
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
