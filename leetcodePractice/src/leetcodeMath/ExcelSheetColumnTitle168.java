package leetcodeMath;

public class ExcelSheetColumnTitle168 {
	//����ʵ�����ǽ�10������ת��Ϊ26������
    public String convertToTitle(int n) {
        StringBuilder out = new StringBuilder();
        n--;
        while(n>=0) {
        	out.append((char)(n%26+'A'));
        	n = n/26-1;//��Ϊ������ÿλ����1��ʼ����26�����Ǵ�0��ʼ����˶���ÿһλ��Ҫ�� n ִ�� -1 ������
        }
        return out.reverse().toString();
    }
    
    public static void main(String[] args) {
		ExcelSheetColumnTitle168 test = new ExcelSheetColumnTitle168();
		System.out.println(test.convertToTitle(27));
	}
}
