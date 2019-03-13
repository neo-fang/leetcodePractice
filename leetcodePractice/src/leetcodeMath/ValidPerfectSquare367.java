package leetcodeMath;

public class ValidPerfectSquare367 {
	//�ⷨ1����ʱ
    public static boolean isPerfectSquare(int num) {
        int increment = 1;
        int tmp = 0;
        while(tmp<num) {
        	tmp += increment;
        	increment += 2;
        }
        return tmp == num;
    }
  //�ⷨ2����ʱ
    public static boolean isPerfectSquare2(int num) {
    	int i = 0;
    	while(i*i<num) i++;
    	return i*i == num;
    }
    public static void main(String[] args) {
		System.out.println(isPerfectSquare2(8));
	}
}
