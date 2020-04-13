package practice;

public class GlobalLocalInversions {

	public boolean isIdealPermutation(int[] A) {
		if(A.length==1 || A.length==2)
			return true;
		
		int min = A[A.length-1];
        for(int i=A.length-3;i>=0;i--) {
            min = Math.min(min,A[i+2]);
        	if(A[i]>min) {
        		return false;
        	}        	
        }
        
        return true;
    }

	public static void main(String[] args) {
		GlobalLocalInversions gl = new GlobalLocalInversions();
		System.out.println(gl.isIdealPermutation(new int[] {1,2,0,3}));
	}

}
