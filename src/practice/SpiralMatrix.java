package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        int dir = 0;
        int rl = matrix[0].length-1;
        int dl = matrix.length-1;
        int ll = 0;
        int tl = 1;
        
        LinkedList<Integer> result = new LinkedList<>();
        int i=0, j=0;
        int total = matrix.length*matrix[0].length;
        for(int k=0;k<total;){
            if(dir==0){
                while(j<=rl){
                    result.add(matrix[i][j++]);
                    k++;
                }
                if(k==total)
                		break;
                j--;
                i++;
                rl--;
                dir = 1;
            }
            if(dir==1){
                while(i<=dl){
                    result.add(matrix[i++][j]);
                    k++;
                }
                if(k==total)
            			break;
                i--;
                j--;
                dl--;
                dir = 2;
            }
            if(dir==2){
                while(j>=ll){
                    result.add(matrix[i][j--]);
                    k++;
                }
                if(k==total)
            			break;
                j++;
                i--;
                ll++;
                dir = 3;
            }
            if(dir==3){
                while(i>=tl){
                    result.add(matrix[i--][j]);
                    k++;
                }
                if(k==total)
            			break;
                i++;
                j++;
                tl++;
                dir = 0;
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		List<Integer> l = sm.spiralOrder(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}});
		System.out.println(Arrays.toString(l.toArray()));
	}
}
