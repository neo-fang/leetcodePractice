package leetcodeMath;

public class AddBinary67 {
	//我的解法1（错误：出现int类型数值溢出）
	//先转化为整数加法，再转化为二进制字符串
    public String addBinary(String a, String b) {
        int num1 = binaryToInt(a);
        int num2 = binaryToInt(b);
       return  Integer.toBinaryString(num1+num2);
    }
    public int binaryToInt(String a) {
    	int n = a.length();
    	int res = 0;
    	for(int i=0;i<n;i++) {
    		res += (a.charAt(i)-'0')*Math.pow(2, n-i-1);
    	}
    	return res;
	}
    //我的解法2：直接用字符串计算(未完成，太麻烦)
    public String addBinary2(String a, String b) {
    	int m = a.length();
    	int n = b.length();
    	boolean over = false;
    	StringBuilder out = new StringBuilder();
    	for(int i=0;i<Math.min(m, n);i++) {
    		if(a.charAt(m-i)=='1'&&b.charAt(n-i)=='1') {
    			if(over)	out.append('1');
    			else out.append('0');
    			over = true;
    		}else {
    			if((a.charAt(m-i)=='1'||b.charAt(n-i)=='1')&&over) {
    				out.append('0');
    				over = true;
    			}else if(a.charAt(m-i)=='0'&&b.charAt(n-i)=='0') {
    				out.append('0');
    				over = false;
    			}else {
    				out.append('1');
        			over = false;
    			}  			
    		}
    	}
    	//还需要判断其中一个结束时，且含有进位时，剩下字符串的情况（太复杂）
    	
    	return out.reverse().toString();
    }
    
    //作者解法（对进位问题以及字符串长度问题的考虑上非常巧妙）
    public String addBinary3(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder str = new StringBuilder();
        while (carry == 1 || i >= 0 || j >= 0) {
            if (i >= 0 && a.charAt(i--) == '1') {
                carry++;
            }
            if (j >= 0 && b.charAt(j--) == '1') {
                carry++;
            }
            str.append(carry % 2);
            carry /= 2;
        }
        return str.reverse().toString();
    }
    
    public static void main(String[] args) {
		AddBinary67 test = new AddBinary67();
		//System.out.println(test.binaryToInt("1000"));
		System.out.println(test.addBinary3("1010", "1011"));
	}
}
