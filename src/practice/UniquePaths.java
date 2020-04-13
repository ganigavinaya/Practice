package practice;

import java.util.Arrays;

public class UniquePaths {

	int totalPaths(int[][] grid, int i, int j, int[][] dp){
		int total = 0;

		if(i==grid.length-1 && j==grid[0].length-1)
			return 1;

		if(grid[i][j]==1){
			return 0;
		}

		if(i<grid.length-1){
			if(dp[i+1][j]==-1) {
				dp[i+1][j] = totalPaths(grid, i + 1, j, dp);
			}
			total += dp[i+1][j];
		}

		if(j<grid[0].length-1){
			if(dp[i][j+1]==-1) {
				dp[i][j + 1] = totalPaths(grid, i, j + 1, dp);
			}
			total += dp[i][j+1];
		}

		return total;
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

		for(int[] x:dp){
			Arrays.fill(x,-1);
		}

		return totalPaths(obstacleGrid,0,0,dp);
	}


	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();

		System.out.println(up.uniquePathsWithObstacles(new int[][]{{0,0,0,},{0,1,0},{0,0,0}}));
	}
}
