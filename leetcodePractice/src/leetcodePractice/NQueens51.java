package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class NQueens51 {
    public static boolean isValidQueue(int x,int y,List<StringBuilder> tmpList,int n) {//判断位置(x,y)能否放皇后
//		for(int i=0;i<n;i++) {
//			if((i!=y&&tmpList.get(x).charAt(i)=='Q')||(i!=x&&tmpList.get(i).charAt(y)=='Q')) return false;
//			for(int j=0;j<n;j++) {
//				if(i==x&&j==y) continue;
//				if(Math.abs(i-x)==Math.abs(j-y)&&tmpList.get(i).charAt(j)=='Q') return false;
//			}
//		}
    	for(int i=0;i<x;i++) {//依次遍历0~x-1行
    		int queenIndex = tmpList.get(i).indexOf("Q");
    		if(queenIndex==y) return false;//第i行的皇后位置
    		if(Math.abs(queenIndex-y)==Math.abs(i-x)) return false;
    	}
		return true;
	}
	
    public static List<List<String>> solveNQueens(int n) {
    	List<List<String>> queenList = new ArrayList<>();
    	List<StringBuilder> tmpList = new ArrayList<>();
    	for(int i=0;i<n;i++) {//生成初始二维数列
    		StringBuilder tmpString = new StringBuilder();
    		for(int j=0;j<n;j++) {
    			tmpString.append('.');
    		}
    		tmpList.add(tmpString);
    	}
    	validNQueens(n, 0, tmpList, queenList);
    	return queenList;
    }
    
    public static void validNQueens(int n,int curLayer,List<StringBuilder> tmpList,List<List<String>> queenList) {
    	if(curLayer == n) {
    		List<String> changList = new ArrayList<>();
    		for(StringBuilder tmp:tmpList) {
    			changList.add(tmp.toString());
    		}
    		queenList.add(changList);
    		return ;
    	}
    	for(int i=0;i<n;i++) {
    		tmpList.get(curLayer).setCharAt(i, 'Q');
    		if(isValidQueue(curLayer, i, tmpList, n)) {
    			validNQueens(n, curLayer+1, tmpList, queenList);
    		}
    		tmpList.get(curLayer).setCharAt(i, '.');
    	}	
  }
    /*
    public static boolean validNQueens(int n,int curLayer,List<StringBuilder> tmpList,List<List<StringBuilder>> queenList) {
    	if(curLayer == n) {
    		queenList.add(new ArrayList<StringBuilder>(tmpList));
    		return true;
    	}
    	for(int i=0;i<n;i++) {
    		tmpList.get(curLayer).setCharAt(i, 'Q');
    		if(isValidQueue(curLayer, i, tmpList, n)&&validNQueens(n, curLayer+1, tmpList, queenList)){
				return true;
    		}
    		tmpList.get(curLayer).setCharAt(i, '.');
    	}
    	return false;		
   }
	*/
    
    public static void main(String[] args) {
//    	int n = 3;
//    	List<String> qList = new ArrayList<>();
//    	for(int i=0;i<n;i++) {
//    		StringBuilder tmpString = new StringBuilder();
//    		for(int j=0;j<n;j++) {
//    			tmpString.append('.');
//    		}
//    		qList.add(String.valueOf(tmpString));
//    	}
//    	System.out.println();
    	int n=4;
    	System.out.println(solveNQueens(n));
    	System.out.println();
	}
}


