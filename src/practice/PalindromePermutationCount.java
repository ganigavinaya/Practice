package practice;

import java.util.ArrayList;
import java.util.HashMap;

public class PalindromePermutationCount {

	public static boolean canPermutePalindrome(String s) {
        if(s.length()==0 || s.length()==1)
            return true;
        
        HashMap<Character,Integer> count = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            count.put(arr[i],count.getOrDefault(arr[i],0)+1);
        }
        
        int odd = 0;
        
        ArrayList<Integer> values = new ArrayList<>(count.values());
        
        for(int v:values) {
        		if(v%2!=0)
        			odd++;
        }
        
        if((arr.length%2==0 && odd==0) || (arr.length%2!=0 && odd==1))
        		return true;
        		
        return false;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canPermutePalindrome("code"));
	}

}
