package practice;

public class CastleNHill {


	static int count(int[] arr){
		int prev = arr[0];

		boolean inc = true;
		boolean dec = true;
		boolean lastValley = false;

		int hill=0;
		int valley=0;

		for(int i=1;i<arr.length;i++){
			if(arr[i]>prev){
				if(dec) {
					valley++;
					lastValley = true;
				}
				inc = true;
				dec=false;
			}
			else if(arr[i]<prev){
				if(inc) {
					hill++;
					lastValley =false;
				}
				inc = false;
				dec=true;
			}
			prev=arr[i];
		}

		if(inc && lastValley)
			hill++;
		else if(dec && !lastValley)
			valley++;

		return hill+valley;
	}

	public static void main(String[] args) {
		System.out.println(count(new int[]{2,2,3,4,3,3,2,2,1,1}));
	}
}
