package practice;

public class MaxChunksSortArray {

	public int maxChunksToSorted(int[] arr) {
		
		int chunkNo = 1;
		int boundary = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(i<=boundary) {
				if(arr[i]>boundary) {
					boundary = arr[i];
				}
			}
			else {
				chunkNo++;
				boundary = arr[i];
			}
		}
        return chunkNo;
    }

	public static void main(String[] args) {
		MaxChunksSortArray mc = new MaxChunksSortArray();
		mc.maxChunksToSorted(new int[] {4,3,2,1,0});
	}

}
