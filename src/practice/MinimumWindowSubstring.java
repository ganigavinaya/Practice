package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {

	public static String minWindow(String s, String t) {
		if (t.length()> s.length()) {
			return "";
		}

		Map<Character, Integer> tMap = new HashMap<>();
		for(char c:t.toCharArray()) {
			tMap.compute(c, (K, V) -> (V == null ? 1 : V + 1));
		}

		Map<Character, Integer> countMap = new HashMap<>();
		String result = "";
		int minLength = Integer.MAX_VALUE;

		Set<Character> countMet = new HashSet<>();
		for(int windowStart=0, windowEnd =0;(s.length()-windowStart)>=t.length() ; windowStart++) {
			char currentChar = s.charAt(windowStart);
			if(tMap.containsKey(currentChar)) {
				if(windowStart > windowEnd) {
					windowEnd = windowStart;
				}
				char startChar = currentChar;
				while(countMet.size() < tMap.size() && windowEnd<s.length()) {
					currentChar = s.charAt(windowEnd++);
					Integer tCharCount = tMap.get(currentChar);
					if(tCharCount != null) {
						countMap.compute(currentChar, (K, V) -> (V == null ? 1 : V + 1));
						if(tCharCount <= countMap.get(currentChar)){
							countMet.add(currentChar);
						}
					}
				}
				if(countMet.size() == tMap.size()) {
					int currentLength = windowEnd - windowStart;
					if (minLength > currentLength) {
						minLength = currentLength;
						result = s.substring(windowStart, windowEnd);
					}
				}
				Integer startCharCount = countMap.get(startChar);
				if(startCharCount == 1) {
					countMap.remove(startChar);
				} else {
					countMap.put(startChar, startCharCount-1);
				}
				if (countMap.get(startChar) == null || tMap.get(startChar) > countMap.get(startChar)) {
					countMet.remove(startChar);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(minWindow("bbaac","aba"));
	}
}
