package leetcodeTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree637 {
	//�ҵĽⷨ�����󣬹�����ȱ�����Ҫ�ö���ʵ�֣�������һ���Ƚ��ȳ��Ľṹ�����ݹ��൱��
	//������ȱ������൱�ڶ�ջ�ṹ��ֻ��ʵ���Ƚ�����Ľṹ
    public List<Double> averageOfLevels(TreeNode root) {
    	int num = 0;
    	int count = 0;
        List<Double> tmpList = new ArrayList<Double>();
        if(root==null) return tmpList;
		if(root!=null) {
			num+=root.val;
			count++;
			tmpList.add((double)num/count);
	        tmpList.addAll(averageOfLevels(root.left));
	        tmpList.addAll(averageOfLevels(root.right));
		}
		return tmpList;
    }
    //��ȷ�ⷨ���������߽ⷨ���ö���ʵ��
    public List<Double> averageOfLevels2(TreeNode root) {
    	List<Double> tmpList = new ArrayList<>();
    	if(root==null) return tmpList;
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		int cnt = queue.size();
    		double sum = 0;
    		for(int i=0;i<cnt;i++) {
    			TreeNode tmp = queue.poll();
    			sum += tmp.val;
    			if(tmp.left!=null)	queue.add(tmp.left);
    			if(tmp.right!=null) queue.add(tmp.right);
    		}
    		tmpList.add(sum/cnt);
    	}
    	return tmpList;
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(3);
		AverageofLevelsinBinaryTree637 test = new AverageofLevelsinBinaryTree637();
		System.out.println(test.averageOfLevels2(root));
	}
}
