package leetcodePractice;

public class SumOfSquareNumbers633 {
	public static boolean judgeSquareSum(int c) {
        int tail = (int)Math.sqrt(c);
        int header = 0;
        while(header<=tail) {
        	if(header*header + tail*tail == c) return true;
        	if(header*header + tail*tail < c) header++;
        	else tail--;
        }
        return false;
    }
	
	public static void main(String[] args) {
		int c = 1000;
		System.out.println(judgeSquareSum(c));
	}
	
}
