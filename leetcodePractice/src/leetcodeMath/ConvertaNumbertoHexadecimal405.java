package leetcodeMath;

public class ConvertaNumbertoHexadecimal405 {
	public String toHex(int num) {
	    char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	    if (num == 0) return "0";
	    StringBuilder sb = new StringBuilder();
	    while (num != 0) {
	        sb.append(map[num & 0b1111]);//0b+���֣���ʾ������Ϊ�����Ʊ�ʾ
	       // System.out.println(num & 0b1111);
	        num >>= 4; // ��Ϊ���ǵ��ǲ�����ʽ����˷���λ�Ͳ�������������壬��Ҫʹ���޷������ƣ������ 0
	    }
	    return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		ConvertaNumbertoHexadecimal405 test = new ConvertaNumbertoHexadecimal405();
		System.out.println(test.toHex(-1));
	}
}
