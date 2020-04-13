package practice;

public class Minesweeper {

	private int[] dr = {0, 0, 1, -1, 1, 1, -1, -1};
    private int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};
	
	int check(char[][] board,int i,int j) {
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int cr = i + dr[k];
            int cc = j + dc[k];
            if (cr < 0 || cr >= board.length || cc < 0 || cc >= board[0].length) continue;
            if (board[cr][cc] == 'M' || board[cr][cc] == 'X') {
                count++;
            }
        }
        return count;
	    	
	}
	
	
	void updateRec(char[][] board,int i,int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'E') 
        		return;
        int num = check(board,i,j);
        
        if (num == 0) {
            board[i][j] = 'B';
            for (int k = 0; k < 8; k++) {
                int cr = i + dr[k];
                int cc = j + dc[k];
                updateRec(board,cr, cc);
            }
        } else {
            board[i][j] = (char)('0' + num);
        }
	   	
		
	}
	
	public char[][] updateBoard(char[][] board, int[] click) {
		if(board[click[0]][click[1]]=='M')
			board[click[0]][click[1]]='X';
		else
			updateRec(board,click[0],click[1]);
        return board;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
