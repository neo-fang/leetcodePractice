package leetcodePractice;

public class CanPlaceFlowers605 {
	//�㷨����ͳ�Ƴ�����2�������յ�����Ŀ����Ч�յ�����������ÿ���յ�����������Ŀ��
	//ͳ���ܵĿ�������Ŀ���Ƚ���n�Ĵ�С��
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int availableNum = 0;
        int adjacent = 0;
        for(int i=0;i<flowerbed.length;i++) {
        	while(i<flowerbed.length&&flowerbed[i] == 0) {
        		adjacent ++;
        		i++;
        	}
        	if(adjacent == flowerbed.length) {//����ȫ��0
        		availableNum = (adjacent + 1)/2;
        		break;
        	}
        	if(adjacent>1) {
        		if(i==flowerbed.length||i==adjacent) {//��ǰ�յ�Ϊ������߽�����ұ߽�
            		availableNum += adjacent/2;
            	}else
            		availableNum += (adjacent-1)/2;
        	}
        	adjacent = 0;
        }
        return availableNum>=n;
    }
	public static void main(String[] args) {
		int[] flowerbed = {0};
		int n = 1;
		System.out.println(canPlaceFlowers(flowerbed, n));
		n = 2;
		System.out.println(canPlaceFlowers(flowerbed, n));
	}
}
