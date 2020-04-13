package practice;

public class MaximumDifference {

	int maximumDifference(int[] arr){
		int maxDiff = -1;

		if(arr.length==0)
			return -1;

		int min = arr[0];

		for(int i=1;i<arr.length;i++){
			if(min>arr[i]){
				min = arr[i];
			}
			else{
				maxDiff = Math.max(maxDiff,arr[i]-min);
			}
		}

		return maxDiff;
	}


	public static void main(String[] args) {
		MaximumDifference md = new MaximumDifference();

		System.out.println(md.maximumDifference(new int[]{2,3,1,10,2,4,8}));
	}
}
