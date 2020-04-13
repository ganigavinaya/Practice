package practice;

public class OddMaxDifference {

	static int oddMaxDiff(int[] arr){
		int maxDiff = -1;

		int oddMin = arr[0]%2==0?-1:arr[0];

		for(int i=1;i<arr.length;i++){
			if(arr[i]%2==0){
				if(oddMin!=-1 && arr[i]>oddMin)
					maxDiff = Math.max(maxDiff,arr[i]-oddMin);
			}
			else{
				if(oddMin==-1)
					oddMin = arr[i];
				else
					oddMin = Math.min(oddMin,arr[i]);
			}
		}

		return maxDiff;
	}

	public static void main(String[] args) {
		System.out.println(oddMaxDiff(new int[]{2,3,5,10,1,9,30}));
	}
}
