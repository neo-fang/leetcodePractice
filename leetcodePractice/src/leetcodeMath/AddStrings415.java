package leetcodeMath;

public class AddStrings415 {
	//此题与AddBinary67解法相同，只是进制不同
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder out = new StringBuilder();
        while(carry==1||i>=0||j>=0) {//存在进位、有数组未计算完时循环
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
