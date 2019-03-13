package leetcodePractice;


public class WordSearch79 {
	//算法：找到矩阵board中开头与word第一个字母相等的位置，存储在列表中，然后从列表中每一个
	//其实位置开始，用回溯法寻找匹配字符串：沿着四个方向寻找下一个字母，再比较下一个字母与word
	//中对应字母是否相等，不相等则寻找该层中另外一个方向，所有方向都找完还不相等，则直接返回false。
    final static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    static int row;
    static int column;
	public static boolean exist(char[][] board, String word) {
        row = board.length;
        column = board[0].length;
        boolean[][] added = new boolean[row][column];
        for(int i=0;i<row;i++) {
        	for(int j=0;j<column;j++) {
        		if(board[i][j]==word.charAt(0)) {
        			if(isMatched(board, word, 0, i,j, added))  return true;
        		}
        	}
        }
        return false;
    }
    public static boolean isMatched(char[][] board,String word,int curIndex, int x,int y,boolean[][] added) {
    	if(added[x][y]||word.charAt(curIndex)!=board[x][y]) {
    		return false;//不相等或者本次已经访问过
    	} 
    	if(curIndex == word.length()-1) {//递归终止条件，正在比较word最后一个字符
    		return true;	
    	}
       	added[x][y] = true;
       	boolean exitOne = false;
    	for(int[] dir:direction){
    		if(x+dir[0]<0||x+dir[0]>=row||y+dir[1]<0||y+dir[1]>=column
    				||added[x+dir[0]][y+dir[1]])	continue;
    		exitOne = exitOne|| isMatched(board, word, curIndex+1, x+dir[0], y+dir[1], added);//此处可以改进
    	}
    	if(exitOne) return true;
    	else {
    		added[x][y] = false;//四个方向都有问题，应当撤销对节点startPoint的标标记
    		return false;
    	}
	}
    public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word = "BFCCESEF";
		System.out.println(exist(board, word));
	}
}
    
    /*example
 board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
     * */
