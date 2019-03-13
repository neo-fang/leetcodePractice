package leetcodePractice;

public class CanPlaceFlowers605 {
	//算法：先统计出大于2的相连空地区数目（有效空地区），计算每个空地区可栽种数目，
	//统计总的可栽种数目，比较与n的大小。
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int availableNum = 0;
        int adjacent = 0;
        for(int i=0;i<flowerbed.length;i++) {
        	while(i<flowerbed.length&&flowerbed[i] == 0) {
        		adjacent ++;
        		i++;
        	}
        	if(adjacent == flowerbed.length) {//数组全是0
        		availableNum = (adjacent + 1)/2;
        		break;
        	}
        	if(adjacent>1) {
        		if(i==flowerbed.length||i==adjacent) {//当前空地为数组左边界或者右边界
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
