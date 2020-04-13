package practice;

public class TripAppeal {

	static int appeal(int[] arr){
		int[] i_arr = new int[arr.length];
		int[] j_arr = new int[arr.length];

		int maxI = Integer.MIN_VALUE;
		int indexI = -1;
		int maxJ = Integer.MIN_VALUE;
		int indexJ = -1;
		for(int i=0;i<arr.length;i++){
			i_arr[i]=arr[i]+i;
			if(maxI<i_arr[i]){
				maxI = i_arr[i];
				indexI = i;
			}
			j_arr[i]=arr[i]-i;
			if(maxJ<j_arr[i]){
				maxJ = j_arr[i];
				indexJ = i;
			}
		}

		return arr[indexI]+arr[indexJ]+Math.abs(indexI-indexJ);

	}

	public static void main(String[] args) {
		System.out.println(appeal(new int[]{4,3,-3,6,8}));
	}
}
