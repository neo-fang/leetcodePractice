package leetcodePractice;


public class TwoSum167 {//���ظ�Ԫ��
	//�ҵĽⷨ���������numbers=[-1,0]��target=-1��
		public static  int[] myTwoSum(int[] numbers, int target) {
			if(numbers[0]>=target||numbers[numbers.length-1]<target/2) return null;
			int i=0;
			int middle = -1;
			int up = -1;
			//�ҵ���һ������target������λ��up������ܵ��±�ֻ��0~up-1֮��
			while(numbers[i]<target/2&&i<numbers.length) {
				i++;
			}
			middle = i;
			//�ҵ���һ�����ڵ���target/2������λ��middle�����С���±���0~middle-1֮�䣬���ϴ���±���middle~up-1֮��
			if(numbers[numbers.length-1]<target) up = numbers.length;
			else {
				while(numbers[i]<target&&i<numbers.length) {
					i++;
				}
				up = i;
			}
			//��0~middle-1֮��ѡȡһ������Ϊ�±꣬middle~up-1֮��ѡȡһ������Ϊ�ϱ꣬������ϱȽ�
			for(i=0;i<middle;i++) {
				for(int j = middle;j<up;j++) {
					if(numbers[i]+numbers[j]==target) return new int[] {i,j};
				}
			}
			return null;
		
	    }
		
		//һ�ּ򵥵���ȷ�ⷨ
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
