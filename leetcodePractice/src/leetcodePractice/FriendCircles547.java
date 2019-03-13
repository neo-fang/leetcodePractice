package leetcodePractice;

public class FriendCircles547 {
    public static int findCircleNum(int[][] M) {
    	final int m = M.length;
    	boolean[] inAcircle = new boolean[m];//用来标记某个朋友是否已经在朋友圈中
    	int circleNum = 0;
    	for(int i=0;i<m;i++) {
    		if(!inAcircle[i]) {
    			inAcircle[i] = true;
        		circleNum++;
        		findCircle(i, M, inAcircle);
    		}
    	}
    	return circleNum;
    }
    public static void findCircle(int i,int[][] M, boolean[] inAcircle) {
    	for(int j=0;j<M.length;j++) {
    		if(j==i) continue;
    		if(!inAcircle[j]&&M[i][j] == 1) {
    			//M[i][j] = M[j][i] = 0;
    			inAcircle[j] = true;
    			findCircle(j, M,inAcircle);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	int[][] M = {
    			{1,1,0},
    			{1,1,0},
    			{0,0,1}
    	};
    	System.out.println(findCircleNum(M));
	}
}
