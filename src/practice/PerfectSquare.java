package practice;

public class PerfectSquare {

	public int numSquares(int n) {
        if (n==1)
            return 1;
        if (n==0)
            return 0;
        int[] ans = new int[n+1];
        
        ans[0] = 0;
        
        for(int i=1;i<=n;i++)
            ans[i] = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j*j<=i;j++)
            {
                    ans[i]= Math.min(ans[i], ans[i-j*j]+1);
                
            }
        }
        return ans[n];
    }
	
	public static void main(String[] args) {
		PerfectSquare ps = new PerfectSquare();
		System.out.println(ps.numSquares(17));

	}

}
