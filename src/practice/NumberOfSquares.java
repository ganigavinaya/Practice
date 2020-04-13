package practice;

import java.util.Comparator;
import java.util.TreeSet;

public class NumberOfSquares {

	TreeSet<Integer> squares = new TreeSet<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {			
			return o2-o1;
		}
	});
	private void getSquares(int n) {
		int square = 1;
		int i=1;
		do{
			squares.add(square);
			i++;
			square = i*i;
		}while(square<=n);
		
	}
	
    
    int getLeast(int n) {
		if(squares.contains(n)) {
			return 1;
		}
		int[] matrix = new int[n+1];
        matrix[0]=0;
        matrix[1]=1;
        
        for(int i=2;i<=n;i++){
            int res = Integer.MAX_VALUE;
            if(squares.contains(i)) {
            		matrix[i]=1;
            		continue;
	    		}
            for(int j=1;j<=Math.ceil(i/2);j++){
                res = Math.min(res,matrix[j]+matrix[i-j]);
            }
            matrix[i]=res;
        }
        return matrix[n];
	}

	public int numSquares(int n) {
		if(n==1)
			return 1;
		getSquares(n);
		
        return getLeast(n);
    }
	
	public static void main(String[] args) {
		NumberOfSquares ns = new NumberOfSquares();
		System.out.println(ns.numSquares(200));

	}

}
