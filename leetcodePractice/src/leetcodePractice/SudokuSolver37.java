package leetcodePractice;

public class SudokuSolver37 {
    public static void solveSudoku(char[][] board) {
        if(isValidSuDo(board,0,0)){
        	System.out.println("可解");
        }else {
        	System.out.println("不可解");
        }
    }
    
    public static boolean isValidSuDo(char[][] board,int nextX,int nextY) {
    	if(nextX==8&&nextY==8) return true;
    	for(int i=nextX;i<9;i++) {
    		for(int j=0;j<9;j++) {
    			if(board[i][j]=='.') {
    				for(int k=0;k<9;k++) {
    					board[i][j] = (char) ('1'+k);
    					if(isValidPlace(board, i, j)&&isValidSuDo(board,i,j)) {
    						return true;
    					}
    					board[i][j] = '.';
    				}
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    public static boolean isValidPlace(char[][] board,int curX,int curY) {//判断当前位置放数字k是否可行
		for(int i=0;i<9;i++) {//同一行同一列没有出现相同元素
			if((i!=curY&&board[curX][i]==board[curX][curY])||(i!=curX&&board[i][curY]==board[curX][curY])) {
				return false;
			} 
		}
		for(int i=3*(curX/3);i<3*(curX/3+1);i++) {
			for(int j=3*(curY/3);j<3*(curY/3+1);j++) {
				if(i==curX&&j==curY) continue;
				if(board[i][j]==board[curX][curY]) return false;
			}
		}
		return true;
	}
    
    public static void main(String[] args) {
		char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'},
		};
		solveSudoku(board);
		System.out.println();
	}
}
