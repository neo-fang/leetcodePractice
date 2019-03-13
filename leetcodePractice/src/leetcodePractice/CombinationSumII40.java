package leetcodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	//HashSet<List<Integer>> finalList =new HashSet<>();
    	List<List<Integer>> finalList = new ArrayList<>();
    	List<Integer> tmpList = new ArrayList<>();
    	boolean[] visited = new boolean[candidates.length];
    	Arrays.sort(candidates);
    	calculate(candidates, target, visited,0, finalList, tmpList);
    	return new ArrayList<>(finalList);
    }
    public static void calculate(int[] candidates, int target,boolean[] visited, int candidateIndex,List<List<Integer>> finalList,List<Integer> tmpList) {
    	if(target == 0) {
    		finalList.add(new ArrayList<>(tmpList));//�ҵ���������
			return;
		}
    	if(target<0||candidateIndex==candidates.length) return;
    	for(int i=candidateIndex;i<candidates.length;i++) {
    		if(i!=0&&candidates[i]==candidates[i-1]&&!visited[i-1]) continue;//��һ����ȥ���ظ��б���ؼ���һ��
    		tmpList.add(candidates[i]);
    		visited[i] = true;
    		//���󣨺���Ԫ�ش���ǰ��Ԫ�أ���ԭ�򣺱��μ���candidates[i]�����±�Ϊi��i>=candidateIndex�������ڴ�����һ�ε���candidateIndex+1��
    		//����п��ܳ��ֱ��ε�iֵ������һ�εݹ���candidateIndex+1Ϊ��ֵ����ѭ����iֵ�����п��ܺ���Ԫ�ر�ǰ��󣬶������±�Ϊi+1ʱ����һ����ȷ��
    		//����Ԫ�ر�ǰ���
    		//calculate(candidates, target-candidates[i],visited, candidateIndex+1, finalList, tmpList);//����
    		calculate(candidates, target-candidates[i],visited,i+1, finalList, tmpList);//��ȷ
    		tmpList.remove(tmpList.size()-1);
    		visited[i] = false;
    	}
	}
    public static void main(String[] args) {
    	int[] candidates = {10,1,2,7,6,1,5};
    	int target = 8;
    	System.out.println(combinationSum(candidates, target));
	}
}
