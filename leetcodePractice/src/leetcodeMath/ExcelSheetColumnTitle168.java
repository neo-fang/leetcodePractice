package leetcodeMath;

public class ExcelSheetColumnTitle168 {
	//本题实际上是将10进制数转化为26进制数
    public String convertToTitle(int n) {
        StringBuilder out = new StringBuilder();
        n--;
        while(n>=0) {
        	out.append((char)(n%26+'A'));
        	n = n/26-1;//因为题意中每位数从1开始，而26进制是从0开始，因此对与每一位需要对 n 执行 -1 操作。
        }
        return out.reverse().toString();
    }
    
    public static void main(String[] args) {
		ExcelSheetColumnTitle168 test = new ExcelSheetColumnTitle168();
		System.out.println(test.convertToTitle(27));
	}
}
