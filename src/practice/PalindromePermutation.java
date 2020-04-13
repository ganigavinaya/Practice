package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class PalindromePermutation {

	List<String> result = new ArrayList<>();
	String odd="";
	
	void recursionFun(StringBuilder s,int start) {
		char[] c = s.toString().toCharArray();
		Arrays.sort(c);

		s = new StringBuilder();
		for(char ch:c) {
			s.append(ch);
		}

		StringBuilder sb = new StringBuilder(s);
		result.add(s.toString()+odd+sb.reverse());
		
		while(true) {
			int j = s.length()-2;
			while(j>=0 && s.charAt(j)>=s.charAt(j+1)) {
				j--;
			}
			if(j==-1)
				break;
			int k = s.length()-1;
			while(s.charAt(j)>=s.charAt(k)) {
				k--;
			}
			char temp = s.charAt(j);
			s.setCharAt(j, s.charAt(k));
			s.setCharAt(k, temp);
			
			sb = new StringBuilder(s.substring(j+1));
			sb.reverse();
			s.delete(j+1,s.length());
			s.append(sb);
			
			sb = new StringBuilder(s);
			result.add(s.toString()+odd+sb.reverse());
		}
		System.out.println(Arrays.toString(result.toArray(new String[result.size()])));
	}
	public List<String> generatePalindromes(String s) {
		HashMap<Character,Integer> count = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            count.put(arr[i],count.getOrDefault(arr[i],0)+1);
        }
        
        	StringBuilder sb = new StringBuilder();

    		for(Entry<Character,Integer> c:count.entrySet()) {
    			int value = c.getValue();
    			Character key = c.getKey();
    			while(value>1) {
    				sb.append(key);
    				value-=2;
    			}
    			if(value==1) {
                if(odd.equals(""))
				    		odd = key+"";
                else
                    return result;
    			}
    		}
    		if((arr.length%2==0 && odd.equals("")) || (arr.length%2!=0 && !odd.equals(""))) {	
        		recursionFun(sb,0);
    		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePermutation pp = new PalindromePermutation();
		pp.generatePalindromes("malayalam");
		
	}

}
