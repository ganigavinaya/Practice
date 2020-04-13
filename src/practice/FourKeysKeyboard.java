package practice;

public class FourKeysKeyboard {

	
	static int findoptimal(int N)
    {
        // The optimal string length is N 
        // when N is smaller than 7
        if (N <= 6)
            return N;
     
        // An array to store result
        // of subproblems
        int screen[] = new int[N+1];
     
     
        // Initializing the optimal lengths 
        // array for uptil 6 input strokes
        int n;
        for (n = 0; n < 7; n++)
            screen[n] = n;
     
        int paste = 1;
        // Solve all subproblems in bottom manner
        for (n = 7; n <= N; n++)
        {         
     
            for(int b=n-3; b>=1; b--) {
            		int numA = screen[b]*(n-b-paste);
            		if(numA>screen[n]) {
            			screen[n]=numA;
            		}
            }
        }
     
        return screen[N];
    }
     
	public static void main(String[] args) {
        
        System.out.println("Maximum Number of A's with keystrokes is "+ findoptimal(40));

	}

}
