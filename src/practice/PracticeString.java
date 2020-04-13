package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PracticeString {
	public static void longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return ;
        }
        
        char[] minPrefix = strs[0].toCharArray();

        int l = minPrefix.length-1;
        for(int i=1;i<strs.length;i++){
            char[] curArr = strs[i].toCharArray();

            if(l>=curArr.length){
                l=curArr.length-1;
            }

            for(int j=l;j>=0;j--){
                if(curArr[j]!=minPrefix[j]){
                    l=j-1;
                }
            }
            if(l==-1){
                return ;
            }
        }        
        System.out.println(String.valueOf(minPrefix).substring(0,l+1));
    }
	
	public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        
        char[] strArr = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int len = 0;
        int start = -1, end = -1;
        for(int i=0;i<strArr.length;i++){
            Integer index = map.get(strArr[i]);
            if(index!=null){
                if(index>start){
                    start=index;     
                }
            }
            map.put(strArr[i],i);
            end=i;
            if(len<(end-start)){
                len = (end-start);
            }
        }
        
        return len;
    }
	
	
	
	List<String> res = new ArrayList<String>();
    
    HashMap<String,String[]> map = new HashMap<>();
    
    
    public List<String> letterCombinations(String digits) {
        
        if(digits.length()==0)
            return null;
        
        map.put("2",new String[]{"a","b","c"});
        map.put("3",new String[]{"d","e","f"});
        map.put("4",new String[]{"g","h","i"});
        map.put("5",new String[]{"j","k","l"});
        map.put("6",new String[]{"m","n","o"});
        map.put("7",new String[]{"p","q","r","s"});
        map.put("8",new String[]{"t","u","v"});
        map.put("9",new String[]{"w","x","y","z"});
        res.add("");
        
        for(char c:digits.toCharArray()) {
        		getAllCombinations(c+"");
        }
        
        return res;
 
    }
    
    void getAllCombinations(String add){
    		List<String> mockList = new ArrayList<>();

		for(String c:map.get(add)) {	
			for(String each:res){
				mockList.add(c+each);
	        }
    		}
		
		res = mockList;
        
    }
    
    private static void _printParenthesis(char str[], int pos, int n, int open, int close)
    {
        if(close == n) 
        {
            // print the possible combinations
            for(int i=0;i<str.length;i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        }
        else
        {
            if(open > close) {
                str[pos] = ')';
                _printParenthesis(str, pos+1, n, open, close+1);
            }
            if(open < n) {
                str[pos] = '(';
                _printParenthesis(str, pos+1, n, open+1, close);
            }
        }
    }
     
    // Wrapper over _printParenthesis()
    public static void printParenthesis(char str[], int n)
    {
        if(n > 0)
        _printParenthesis(str, 0, n, 0, 0);
        return;
    }
	
	public static void main(String[] args) {
//		PracticeString.longestCommonPrefix(new String[] {"abc","abcde","a",""});
//		PracticeString.lengthOfLongestSubstring("pwwkew");

		PracticeString.printParenthesis( new char[100], 3);
	}
}
