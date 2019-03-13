package leetcodePractice;


public class WordSearch79 {
	//�㷨���ҵ�����board�п�ͷ��word��һ����ĸ��ȵ�λ�ã��洢���б��У�Ȼ����б���ÿһ��
	//��ʵλ�ÿ�ʼ���û��ݷ�Ѱ��ƥ���ַ����������ĸ�����Ѱ����һ����ĸ���ٱȽ���һ����ĸ��word
	//�ж�Ӧ��ĸ�Ƿ���ȣ��������Ѱ�Ҹò�������һ���������з������껹����ȣ���ֱ�ӷ���false��
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
    		return false;//����Ȼ��߱����Ѿ����ʹ�
    	} 
    	if(curIndex == word.length()-1) {//�ݹ���ֹ���������ڱȽ�word���һ���ַ�
    		return true;	
    	}
       	added[x][y] = true;
       	boolean exitOne = false;
    	for(int[] dir:direction){
    		if(x+dir[0]<0||x+dir[0]>=row||y+dir[1]<0||y+dir[1]>=column
    				||added[x+dir[0]][y+dir[1]])	continue;
    		exitOne = exitOne|| isMatched(board, word, curIndex+1, x+dir[0], y+dir[1], added);//�˴����ԸĽ�
    	}
    	if(exitOne) return true;
    	else {
    		added[x][y] = false;//�ĸ����������⣬Ӧ�������Խڵ�startPoint�ı���
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
