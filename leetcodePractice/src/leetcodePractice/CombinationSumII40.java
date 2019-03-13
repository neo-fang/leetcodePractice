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
    		finalList.add(new ArrayList<>(tmpList));//找到合适数列
			return;
		}
    	if(target<0||candidateIndex==candidates.length) return;
    	for(int i=candidateIndex;i<candidates.length;i++) {
    		if(i!=0&&candidates[i]==candidates[i-1]&&!visited[i-1]) continue;//这一步是去除重复列表最关键的一步
    		tmpList.add(candidates[i]);
    		visited[i] = true;
    		//错误（后面元素大于前面元素）的原因：本次加入candidates[i]，即下标为i（i>=candidateIndex），由于传入下一次的是candidateIndex+1，
    		//因此有可能出现本次的i值大于下一次递归以candidateIndex+1为初值进行循环的i值，所有可能后面元素比前面大，而传入下标为i+1时，则一定能确保
    		//后面元素比前面大
    		//calculate(candidates, target-candidates[i],visited, candidateIndex+1, finalList, tmpList);//错误
    		calculate(candidates, target-candidates[i],visited,i+1, finalList, tmpList);//正确
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
