package practice;

public class RodCuttingProblem {

	static int cutRod(int[] prices,int N) {
		
		int[] cut = new int[N+1];
		cut[0]=0;
		for(int i=1;i<=N;i++) {
			int max = prices[i-1];
			for(int j=0;j<i;j++) {
				max = Math.max(cut[i-j]+cut[j], max);
			}
			cut[i] = max; 
		}
		
		return cut[N];		
	}
	public static void main(String[] args) {
		System.out.println(cutRod(new int[] {1, 5, 8, 9, 10, 17, 17, 20}, 7));
	}

}
