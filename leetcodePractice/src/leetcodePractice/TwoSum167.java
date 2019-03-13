package leetcodePractice;


public class TwoSum167 {//无重复元素
	//我的解法，错误情况numbers=[-1,0]，target=-1。
		public static  int[] myTwoSum(int[] numbers, int target) {
			if(numbers[0]>=target||numbers[numbers.length-1]<target/2) return null;
			int i=0;
			int middle = -1;
			int up = -1;
			//找到第一个大于target的数的位置up，则可能的下标只在0~up-1之间
			while(numbers[i]<target/2&&i<numbers.length) {
				i++;
			}
			middle = i;
			//找到第一个大于等于target/2的数的位置middle，则较小的下标在0~middle-1之间，而较大的下标在middle~up-1之间
			if(numbers[numbers.length-1]<target) up = numbers.length;
			else {
				while(numbers[i]<target&&i<numbers.length) {
					i++;
				}
				up = i;
			}
			//在0~middle-1之间选取一个数作为下标，middle~up-1之间选取一个数作为上标，进行组合比较
			for(i=0;i<middle;i++) {
				for(int j = middle;j<up;j++) {
					if(numbers[i]+numbers[j]==target) return new int[] {i,j};
				}
			}
			return null;
		
	    }
		
		//一种简单的正确解法
		public static int[] trueTwoSum(int[] numbers, int target) {
			int header = 0;
			int tail = numbers.length-1;
			while(numbers[header]+numbers[tail]!=target&&header!=tail) {
				if(numbers[header]+numbers[tail]>target)	tail--;
				if(numbers[header]+numbers[tail]<target) 	header++;
			}
			if(numbers[header]+numbers[tail]==target) return new int[] {header+1,tail+1};
			return null;
		}
		public static void main(String[] args) {
			int[] numbers = {2,7,11,15};
			int target = 9;
			int[] output = new int[2];
			output = trueTwoSum(numbers, target);
			System.out.println(output[0] + "," + output[1]);
		}
}
