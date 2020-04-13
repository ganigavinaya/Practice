package practice;

public class SumSubArrayMinimum {

	static int sumSubArrayMins(int[] A) {
		int sum = 0;

		for(int i=0;i<A.length;i++){
			int min = A[i];
			for(int j=0;j<=i;j++){
				min = Math.min(min,A[j]);
			}
			sum=(sum+min)%1000000007;
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(sumSubArrayMins(new int[]{3,1,2,4}));
	}
}
