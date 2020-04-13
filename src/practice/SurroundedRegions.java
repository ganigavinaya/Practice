package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SurroundedRegions {
	
	boolean[][] seen;
	boolean[][] canbeX;
	char[][] board;
	boolean makeX(int i,int j,List<String> temp,HashSet<String> parent) {
						
		if(board[i][j]=='X')
			return true;
			
		seen[i][j]=true;
		if(i==0 || i==board.length-1 || j==0 || j==board[0].length-1) {
			canbeX[i][j] = false;
			return false;
		}
		
		parent.add(i+" "+j);
		if(parent.contains((i-1)+" "+j) || 
				(seen[i-1][j]?canbeX[i-1][j]:makeX(i-1,j,temp,parent))) {
			if(parent.contains((i+1)+" "+j) 
					|| (seen[i+1][j]?canbeX[i+1][j]:makeX(i+1,j,temp,parent)) ){
				if(parent.contains(i+" "+(j-1)) 
						|| (seen[i][j-1]?canbeX[i][j-1]:makeX(i,j-1,temp,parent))) {
					if(parent.contains(i+" "+(j+1)) 
							|| (seen[i][j+1]?canbeX[i][j+1]:makeX(i,j+1,temp,parent))) {
						canbeX[i][j] = true;
						temp.add(i+" "+j);
						return true;
					}
				}
			}
		}
			
		canbeX[i][j] = false;
		return false;
	}
	
	void changeToX(List<String> temp) {
		for(String s:temp) {
			String[] c=s.split(" ");
			board[Integer.parseInt(c[0])][Integer.parseInt(c[1])]='X';
		}
	}
	public void solve(char[][] board) {
		if(board.length==0)
            return;
		this.board=board;
		seen = new boolean[board.length][board[0].length];
		canbeX = new boolean[board.length][board[0].length];		
		
		for(int i=1;i<board.length-1;i++) {
			for(int j=1;j<board[0].length-1;j++) {
				if(board[i][j]=='O' && !seen[i][j]) {
					List<String> temp = new ArrayList<>();
					HashSet<String> parent = new HashSet<>();
					if(makeX(i,j,temp,parent)) {
						changeToX(temp);
					}
				}
			}
		}
		
    }

	public static void main(String[] args) {
//		char[][] board = new char[][]{{'O','X','O','O','X','X'},
//										{'O','X','X','X','O','X'},
//										{'X','O','O','X','O','O'},
//										{'X','O','X','X','X','X'},
//										{'O','O','X','O','X','X'},
//										{'X','X','O','O','O','O'}};
										
		char[][] board = new char[][]{{'X','X','X','X','X'},
										{'X','O','O','O','X'},
										{'X','X','O','O','X'},
										{'X','X','X','O','X'},
										{'X','O','X','X','X'}};
		SurroundedRegions sr = new SurroundedRegions();
		sr.solve(board);
		for(int i=0;i<board.length;i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}

}
