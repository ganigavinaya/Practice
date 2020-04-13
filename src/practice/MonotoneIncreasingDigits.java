package practice;

public class MonotoneIncreasingDigits {

	public static int monotoneIncreasingDigits(int N) {
		if(N<=9)
			return N;

        char[] arr = (N+"").toCharArray();
        
        int i=0;
        while(i<arr.length-1) {
        	if(arr[i]>arr[i+1]) {
    			arr[i]--;    
    			
    			int prev = i-1;
    			int curr = i;
    			while(prev>=0 && arr[prev]>arr[curr]) {
    				arr[curr]='9';
    				arr[prev]--;
    				prev--;
    				curr--;
    			}
    			while(i<arr.length-1) {
    				arr[i+1]='9';
    				i++;
    			}
    			
        	}        	
        	i++;
        }       
        
        return Integer.parseInt(String.valueOf(arr));
    }
	
	public static void main(String[] args) {
		
		System.out.println(monotoneIncreasingDigits(333222));
	}

}
