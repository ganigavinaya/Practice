package practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {
	
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0)
            return false;
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++) {
    		for(int j=0;j<i;j++) {
    			if(dp[j] && dict.contains(s.substring(j, i))) {
    				dp[i] = true;
    				break;
    			}
    		}
        }
        return dp[s.length()];
        
    }
    
    public static void main(String[] args) {
     	WordBreak w = new WordBreak();
     	List<String> wordDict = new LinkedList<>(); 
     	wordDict.add("le");     
     	wordDict.add("leet");     
     	wordDict.add("code");      	
     	System.out.println(w.wordBreak("leetcode", wordDict));     	
	}
}
