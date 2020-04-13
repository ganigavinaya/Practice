package practice;

import java.util.Arrays;

public class LongestIncreasingPath {

	int[][] score;
	int[][] matrix;
	int findScore(int i, int j) {
		if(i<0 || j<0 || i>matrix.length || j>matrix[0].length)
			return -1;
		if(score[i][j]!=-1) {
			return score[i][j];
		}

		if(i>0) {
			if(matrix[i][j]<matrix[i-1][j])
				score[i][j]=findScore(i-1,j);
			else
				score[i][j]=Math.max(0,score[i][j]);
		}
		if(j>0) {
			if(matrix[i][j]<matrix[i][j-1])
				score[i][j]=Math.max(score[i][j],findScore(i,j-1));
			else
				score[i][j]=Math.max(0,score[i][j]);
		}
		if(i<matrix.length-1) {
			if(matrix[i][j]<matrix[i+1][j])
				score[i][j]=Math.max(score[i][j],findScore(i+1,j));
			else
				score[i][j]=Math.max(0,score[i][j]);
		}
		if(j<matrix[0].length-1) {
			if(matrix[i][j]<matrix[i][j+1])
				score[i][j]=Math.max(score[i][j],findScore(i,j+1));
			else
				score[i][j]=Math.max(0,score[i][j]);
		}
		
		return ++score[i][j];
	
	}
	public int longestIncreasingPath(int[][] matrix) {
        score = new int[matrix.length][matrix[0].length];
        this.matrix = matrix;
        for(int i=0;i<matrix.length;i++) {
        	Arrays.fill(score[i], -1);
        }
        
        int max = 0;
        for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix[0].length;j++) {
        		if(score[i][j]==-1)
        			max = Math.max(max, findScore(i,j));
        		else
        			max = Math.max(max, score[i][j]);
        	}
        }
        
        return max;
    }

	public static void main(String[] args) {
		LongestIncreasingPath lp = new LongestIncreasingPath();
		lp.longestIncreasingPath(new int[][] {{9,9,4},{6,6,8},{2,1,1}});
	}

}
