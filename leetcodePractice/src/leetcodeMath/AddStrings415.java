package leetcodeMath;

public class AddStrings415 {
	//������AddBinary67�ⷨ��ͬ��ֻ�ǽ��Ʋ�ͬ
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder out = new StringBuilder();
        while(carry==1||i>=0||j>=0) {//���ڽ�λ��������δ������ʱѭ��
        	if(i>=0) {
        		carry += num1.charAt(i--)-'0';
        	}
        	if(j>=0) {
        		carry += num2.charAt(j--)-'0';
        	}
        	out.append(carry%10);
        	carry /= 10;
        }
        return out.reverse().toString();
    }
    public static void main(String[] args) {
    	AddStrings415 test = new AddStrings415();
		String num1 = "256";
		String num2 = "769";
		System.out.println(test.addStrings(num1, num2));
	}
}
