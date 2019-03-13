package leetcodeTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FindModeinBinarySearchTree501 {
	//�ⷨ1�����������������mapͳ��ÿ��Ԫ�س��ִ���������map�õ����ִ�������һ������Ԫ��
	HashMap<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        List<Integer> maxList = new ArrayList<>();
        int max = 0;
        for(int cnt:map.values()) {
        	max = max<cnt?cnt:max;
        }
        for(int key:map.keySet()) {
        	if(map.get(key)==max) maxList.add(key);
        }
        int[] maxArray = new int[maxList.size()];
        for(int i=0;i<maxList.size();i++) {
        	maxArray[i] = maxList.get(i);
        }
        return maxArray;
    }
    public void inorder(TreeNode root) {
		if(root==null) return;
		inorder(root.left);
		map.put(root.val,map.getOrDefault(root.val, 0)+1);
		inorder(root.right);
	}
}
