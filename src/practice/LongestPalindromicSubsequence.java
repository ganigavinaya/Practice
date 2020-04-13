package practice;

public class LongestPalindromicSubsequence {

	public static int longestPalindromeSubseq(String s) {
        int length = s.length();
        if(length<=1)
            return length;
        
        int[][] matrix = new int[length][length];
        char[] arr = s.toCharArray();
        
        for(int k=0;k<length;k++){
            for(int i=0,j=k;j<length;j++,i++){
                if(i==j)
                   matrix[i][j]=1; 
                else{
                    if(arr[i]==arr[j]){
                        matrix[i][j]=matrix[i+1][j-1]+2;
                    }
                    else{
                        matrix[i][j]=Math.max(matrix[i][j-1],matrix[i+1][j]);
                    }
                }
            }
        }
        
        return matrix[0][length-1];
    }
	
	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("bbbab"));
	}

}
