package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaximumMultipleSum {

	static int maximumMultipleSum(int[] input) {
		int max = Integer.MIN_VALUE;

		Arrays.sort(input);
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(input[0],input[0]);
		
		for(int i=1;i<input.length;i++) {
			Set<Integer> keys = new HashSet<>(map.keySet());
			boolean flag = false;
			for(Integer x: keys) {
				if(input[i]%x==0) {
					int gain = map.get(x)+input[i];
					map.put(input[i],gain);
					max = Math.max(max, gain);
					flag = true;
				}
				
			}
			if(!flag) {
				map.put(input[i],input[i]); 
				max = Math.max(max, input[i]);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		System.out.println(maximumMultipleSum(new int[] {1,2,3,4,5,9,8,15,18,16,250}));

	}

}
