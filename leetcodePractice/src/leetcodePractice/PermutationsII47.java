package leetcodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
	int n = nums.length;
	Arrays.sort(nums);
	boolean[] isUsed = new boolean[n];
	//��Arraylistȥ�أ�Ч�ʷǳ��ͣ�
	//for(List<Integer> tmp:makePermute(nums, isUsed, 0)){
	//	if(!numList.contains(tmp)) numList.add(tmp);}
	//��HashSet��Ψһ��ȥ�أ�Ч�ʱ�ArrayListȥ�ظ�һ�㣩
	//List<List<Integer>> listWithoutDuplicates = new ArrayList<>(new HashSet<>(makePermute(nums, isUsed, 0)));
	return makePermute(nums, isUsed, 0);
}

public static List<List<Integer>> makePermute(int[] nums,boolean[] isUsed,int time) {
	List<List<Integer>> numList = new ArrayList<>();
	if(time==nums.length-1) {
		for(int i=0;i<nums.length;i++) {
			if(!isUsed[i]) {
    			List<Integer> tmp = new ArrayList<>();
    			tmp.add(nums[i]);
    			numList.add(tmp);	
			}
		}
		return numList;
	}	
	for(int i=0;i<nums.length;i++) {
		if(i!=0&&nums[i]==nums[i-1]&&!isUsed[i-1]) continue;
		//�ڵݹ����һ��ȥ���ظ�����Ϊ�õ���ArrayList�Ĳ�����ȥ�صģ�����Ч�ʸ������ArrayListһ���ͣ�
		if(!isUsed[i]) {
			isUsed[i] = true;
			for(List<Integer> tmpList:makePermute(nums, isUsed, time+1)) {
				tmpList.add(nums[i]);
				//if(time != 0||time==0&&!numList.contains(tmpList)) {
					numList.add(tmpList);
				//}
				
			}
			isUsed[i] = false;//����
		}
	}
	return numList;
}
    public static void main(String[] args) {
    	int[] nums = {1,1,2};
    	System.out.println(permuteUnique(nums));
	}
}
