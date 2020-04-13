package practice;

public class BombEnemy {

	public static int maxKilledEnemies(char[][] grid) {
		if (grid.length == 0)
			return 0;

		int[][] r = new int[grid.length][grid[0].length];
		int[][] c = new int[grid.length][grid[0].length];

		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 'W') {
					c[i][j] = 0;
					r[i][j] = 0;
				} else {
					if (j > 0) {
						r[i][j] = r[i][j - 1];
						if (grid[i][j - 1] == 'E')
							r[i][j]++;
					}
					if (i > 0) {
						c[i][j] = c[i - 1][j];
						if (grid[i - 1][j] == 'E')
							c[i][j]++;
					}

				}
			}
		}

		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (grid[i][j] != 'W') {
					if (i < grid.length - 1) {
						if (grid[i + 1][j] != 'W') {
							if (i == grid.length - 2) {
								if (grid[i + 1][j] == 'E')
									c[i][j]=c[i+1][j]+1;
								else
									c[i][j]=c[i+1][j];
							} else {
								c[i][j] = c[i + 1][j];
								if (i + 2 < grid.length && grid[i + 2][j] == 'W' && grid[i + 1][j] == 'E')
									c[i][j]++;
							}
						}
					}
					if (j < grid[0].length - 1) {
						if (grid[i][j + 1] != 'W') {
							if (j == grid[0].length - 2) {
								if (grid[i][j + 1] == 'E')
									r[i][j]=r[i][j+1]+1;
								else
									r[i][j]=r[i][j+1];
							} else {
								r[i][j] = r[i][j + 1];
								if (j + 2 < grid[0].length && grid[i][j+2] == 'W' && grid[i][j+1] == 'E')
									r[i][j]++;
							}
						}
					}
					if (grid[i][j] != 'E')
						max = Math.max(max, r[i][j] + c[i][j]);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxKilledEnemies(new char[][] 
				{{'W','W','W','W','E','0','E','0','E','0','E'},
				{'W','E','E','E','E','0','0','0','0','0','0'},
				{'E','E','0','E','0','E','E','E','E','E','E'},
				{'W','E','E','E','E','0','0','0','0','0','0'},
				{'0','0','0','0','0','E','E','E','E','E','E'}}));

	}

}
