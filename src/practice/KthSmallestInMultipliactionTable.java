package practice;

public class KthSmallestInMultipliactionTable {

	static boolean withinK(int x,int m,int n, int k) {
		int count = 0;
				
		for(int i=1;i<=m;i++) {
			count+= Math.min(n, x/i);
		}
		return count>=k;
	}
	
	public static int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = m*n;
        
        while(lo<hi) {
        	int mi = lo+(hi-lo)/2;
        	if(withinK(mi,m,n,k)) {
        		hi = mi;
        	}
        	else
        		lo = mi+1;
        }
        
        return lo;
    }
	public static void main(String[] args) {
		findKthNumber(10, 5, 20);

	}

}
