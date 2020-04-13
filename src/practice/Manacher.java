package practice;

public class Manacher
{
	
	String getResultString(char[] newInput, int start, int end){
        StringBuilder sb = new StringBuilder();
        
        for(int i=start;i<=end;i++){
            if(newInput[i]!='$')
                sb.append(newInput[i]);
        }
        
        return sb.toString();
    }
    
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length==0 || length==1)
            return s;
        
        char[] arr = s.toCharArray();
        char[] newInput = new char[arr.length*2+1];
        newInput[0]='$';
        for(int i=1,j=0;i<newInput.length;){
            newInput[i++]=arr[j++];
            newInput[i++]='$';
        }
        
        int start = 0;
        int end = 0;
        int max = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int[] T = new int[newInput.length];
        for(int i=0;i<newInput.length;){
            while(start>0 && end<newInput.length-1 && newInput[start-1]==newInput[end+1]){
                start--;
                end++;
            }
            
            T[i]=(end-start)+1;
            if(max<T[i]){
                max = T[i];
                maxStart = start;
                maxEnd = end;
            }
                    
            if(end==newInput.length-1)
                return getResultString(newInput,maxStart,maxEnd);
            
            int newI = end+(i%2==0?1:0);
            for(int j=i+1;j<=end;j++){
                int leftJ = T[i-(j-i)]; 
                int distEnd = end-j;
                T[j]=Math.min(leftJ,distEnd*2+1);
                
                if(j+T[i-(j-i)]/2==end){
                    newI = j;
                    break;
                }
            }
            
            i = newI;
            start = i-T[i]/2;
            end = i+T[i]/2;
        }
        return getResultString(newInput,maxStart,maxEnd);
    }

    /** Main Function **/
    public static void main(String[] args)
    {    
        Manacher m = new Manacher(); 
        String longestPalindrome = m.longestPalindrome("aabbcbbax"); 
        System.out.println("\nLongest Palindrome : "+ longestPalindrome);    
    }    
}