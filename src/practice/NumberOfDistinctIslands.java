package practice;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
	boolean[][] seen;
	int[][] grid;
	void dfs(int i,int j, int ri, int cj,HashSet<String> shape) {
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || seen[i][j])
			return;
		shape.add((i-ri)+" "+(j-cj));
		seen[i][j]=true;
		dfs(i,j+1,ri,cj,shape);
		dfs(i+1,j,ri,cj,shape);
		dfs(i-1,j,ri,cj,shape);
		dfs(i,j-1,ri,cj,shape);
	}
	
	
	public int numDistinctIslands(int[][] grid) {
		this.grid = grid;
		Set<HashSet<String>> shapes=  new HashSet<>();
		seen = new boolean[grid.length][grid[0].length]; 
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {				
				if(grid[i][j]==1 && !seen[i][j]) {
					HashSet<String> shape = new HashSet<>();
					dfs(i,j,i,j,shape);
					if(shape.size()>0)
						shapes.add(shape);
				}
			}
		}
		
		return shapes.size();
    }

	public static void main(String[] args) {
		NumberOfDistinctIslands nd = new NumberOfDistinctIslands();
		nd.numDistinctIslands(new int[][] {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}});

	}

}
