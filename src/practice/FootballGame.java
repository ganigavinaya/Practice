package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FootballGame {

	static float highestScoreProb(int[] arr){

		HashMap<Integer,Integer> scores = new HashMap<>();

		int total = 0;
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				int total_score = arr[i]+arr[j];
				scores.put(total_score,scores.getOrDefault(total_score,0)+1);
				total++;
			}
		}

		ArrayList<Integer> keys = new ArrayList<>(scores.keySet());
		Collections.sort(keys);

		int highest = keys.get(keys.size()-1);
		return scores.get(highest)/(float)total;


	}

	public static void main(String[] args) {

		System.out.println(highestScoreProb(new int[]{1,2,2,3}));
	}
}
