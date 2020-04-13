package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithKDistinctChar {

    public int longestSubstringKDistinct(String str, int k) {
        int length = str.length();
        if(length==0)
            return 0;
        if(length<k)
            return length;

        Map<Character, Integer> countMap = new HashMap<>();
        int windowStart = 0;
        int maxDistinct = 0;

        for(int windowEnd = 0; windowEnd < length; windowEnd++){
            char startChar = str.charAt(windowStart);
            while(windowEnd<length) {
                char currentChar = str.charAt(windowEnd);
                countMap.compute(currentChar, (K, V) -> (V == null? 1 :V+1));
                if (countMap.size() > k){
                    break;
                }
                windowEnd++;
            }
            if(windowEnd < length) {
                Integer startCharCount = countMap.get(startChar);
                if (startCharCount > 1){
                    countMap.put(startChar, startCharCount-1);
                } else {
                    countMap.remove(startChar);
                }
                maxDistinct = Math.max(maxDistinct, windowEnd-windowStart);
            }
            windowStart++;
        }
        return maxDistinct;

    }
    
	public static void main(String[] args) {
		LongestSubStrWithKDistinctChar lc = new LongestSubStrWithKDistinctChar();
		System.out.println(lc.longestSubstringKDistinct("eceba", 2));

	}

}
