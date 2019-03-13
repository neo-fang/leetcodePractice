package leetcodeMath;

public class Base7504 {
	//有正数也有负数
    public String convertToBase7(int num) {
    	if(num==0)	return "0";
        StringBuilder res = new StringBuilder();
        int i = Math.abs(num);       	
        while(i!=0) {
        	res.append(i%7);
        	i = i/7;
        }
        if(num<0) res.append("-");
        return res.reverse().toString();
    }
    public static void main(String[] args) {
		Base7504 test = new Base7504();
		System.out.println(test.convertToBase7(0));
	}
}
