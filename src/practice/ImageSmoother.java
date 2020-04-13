package practice;

import java.util.Arrays;

public class ImageSmoother {

	public static int[][] imageSmoother(int[][] M) {


		int[][] output = new int[M.length][M[0].length];

		for(int i=0;i<M.length;i++){
			for(int j=0;j<M[0].length;j++){
				int total = 0;
				int neighbours = 0;
				if(i>0){
					neighbours++;
					total+=M[i-1][j];

					if(j>0){
						neighbours++;
						total+=M[i-1][j-1];
					}
					if(j<M[i].length-1){
						neighbours++;
						total+=M[i-1][j+1];
					}
				}
				if(i<M.length-1){
					neighbours++;
					total+=M[i+1][j];

					if(j>0){
						neighbours++;
						total+=M[i+1][j-1];
					}
					if(j<M[i].length-1){
						neighbours++;
						total+=M[i+1][j+1];
					}
				}
				if(j>0){
					neighbours++;
					total+=M[i][j-1];
				}
				if(j<M[i].length-1){
					neighbours++;
					total+=M[i][j+1];
				}

				if(neighbours<8){
					total+=M[i][j];
					neighbours++;
				}

				output[i][j]=total/neighbours;

			}
		}
		return output;
	}

	public static void main(String[] args) {
		int[][] result= ImageSmoother.imageSmoother(new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}});

		for(int i=0;i<result.length;i++){
			System.out.println(Arrays.toString(result[i]));
		}
	}
}
