package practice;

public class MaxIncreaseCitySkyline {

	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		int[] maxRow = new int[grid.length];
		int[] maxCol = new int[grid.length];
		for(int i=0;i<grid.length;i++) {
			maxRow[i] = grid[i][0];
			for(int j=0;j<grid[0].length;j++) {
				maxRow[i]= Math.max(maxRow[i], grid[i][j]);
				maxCol[j]= Math.max(maxCol[j], grid[i][j]);
			}
		}
		
		
		int total = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				int diff = Math.min(maxRow[i], maxCol[j])-grid[i][j];
				total+=diff>0?diff:0;
			}
		}
        return total;
    }

	public static void main(String[] args) {
		maxIncreaseKeepingSkyline(new int[][] {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}});
		
	}

}
