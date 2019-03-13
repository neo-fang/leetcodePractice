package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
	//�ҵĽⷨ
    public static List<List<Integer>> combine(int n, int k) {
    	boolean[] isUsed = new boolean[n+1];
       // HashSet<Integer> isUsed = new HashSet<Integer>();
        return doCombine(isUsed, n, k);
    }
    
    public static List<List<Integer>> doCombine(boolean[] isUsed,int n,int k){
    	List<List<Integer>> numList = new ArrayList<>();
    	if(k==1) {
    		
    		for(int i=1;i<=n;i++) {	
    			if(!isUsed[i]) {
    				List<Integer> tmpList = new ArrayList<>();
    				tmpList.add(i);
    				numList.add(tmpList);
    			} 
    		}
    		return numList;
    	}
    	for(int i=1;i<=n;i++) {
    		if(!isUsed[i]) {
    			isUsed[i] = true;
    			for(List<Integer> tmp:doCombine(isUsed, n, k-1)) {
    				if(i>tmp.get(tmp.size()-1)) {//ȷ���������Ԫ�ض���ԭ���б������Ԫ�أ����һ������
    					tmp.add(i);
    					numList.add(tmp);
    				}
    			}
    			isUsed[i] = false;
    		}
    	}
    	return numList;
    }
    
    //�������ߵĽⷨ
    public static List<List<Integer>> combine2(int n, int k) {
    	List<List<Integer>> numList =new  ArrayList<>();
    	List<Integer> tmpList = new ArrayList<>();
    	doCombine2(n, k, 1, numList, tmpList);
    	return numList;
    }
    public static void doCombine2(final int n,int k,int start,List<List<Integer>> numList, List<Integer> tmpList){
    	if(k==0) {
    		numList.add(new ArrayList<>(tmpList));
    		//numList.add(tmpList);//������Ϊû����������tmpList��������ArrayList�Ὣ��ͬ�Ķ�����и���
    		return;
    	}
    	for(int i=start;i<=n-k+1;i++) {
    		tmpList.add(i);
    		doCombine2(n, k-1, i+1, numList, tmpList);
    		//tmpList.remove(tmpList.size())
    		tmpList.remove(tmpList.size()-1);//��ȥ�����Ԫ�أ�ʵ�ֻ���
    	}
    }
    
    
    public static void main(String[] args) {
		int n=3;
		int k=2;
		System.out.println(combine2(n, k));
	}
}
