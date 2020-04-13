package practice;

public class IslandProblem {
	
	void runDFS(char[][] grid, int i, int j) {
		if(i>=grid.length || j>=grid[0].length)
			return;
		if(grid[i][j]=='1') {
			grid[i][j]='0';
			runDFS(grid,i+1,j);
			runDFS(grid,i,j+1);
		}
	}
	
	public int numIslands(char[][] grid) {
        int cno = 0;
        
        for(int i=0;i<grid.length;i++){
        		for(int j=0;j<grid[0].length;j++){
        	
	        		if(grid[i][j]=='1') {
	        			runDFS(grid,i,j);
	        			cno++;
	        		}
        		}
        }
        
        return cno;
    }
	
	public static void main(String[] args) {
		IslandProblem is = new IslandProblem();
		is.numIslands(new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}});
	}
}
