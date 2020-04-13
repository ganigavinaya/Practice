package practice;

import java.util.Arrays;

public class Matrix01 {
	
	public int[][] updateMatrix(int[][] matrix) {  
		int[][] res = new int[matrix.length][matrix[0].length];
		
		for(int i=0;i<matrix.length;i++)
			Arrays.fill(res[i], Integer.MAX_VALUE);
        
        for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix[0].length;j++) {
        		if(matrix[i][j]==0)
        			res[i][j]=0;
        		else {
        			res[i][j]=Math.min(i>0?res[i-1][j]:Integer.MAX_VALUE, 
        					j>0?res[i][j-1]:Integer.MAX_VALUE);
        			if(res[i][j]!=Integer.MAX_VALUE)
        				res[i][j]++;
        		}
        	}
        }
        
        for(int i=matrix.length-1;i>=0;i--) {
        	for(int j=matrix[0].length-1;j>=0;j--) {
        		if(matrix[i][j]!=0) {
	        		int minNeighbour = Math.min(i<matrix.length-1?res[i+1][j]+1:Integer.MAX_VALUE, 
	    					j<matrix[0].length-1?res[i][j+1]+1:Integer.MAX_VALUE);	        		
	        		res[i][j]=Math.min(res[i][j],minNeighbour);	        		
        		}
        	}
        }
        
        
        return res;
    }

	public static void main(String[] args) {
		Matrix01 m01 = new Matrix01();
		m01.updateMatrix(new int[][] {{1,1,1},{1,0,0},{0,0,0}});
	}

}
