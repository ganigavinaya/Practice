package practice;

import java.util.*;

public class SocialNetwork {

	static void socialGraphs(int[] counts){
		HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();

		for(int i=0;i<counts.length;i++){
			TreeSet<Integer> set = map.getOrDefault(counts[i],new TreeSet<>());
			set.add(i);
			map.put(counts[i],set);
		}

		ArrayList<Integer> groups = new ArrayList<>(map.keySet());

		groups.sort(Comparator.comparingInt(o -> map.get(o).first()));

		for(Integer key:groups){
			TreeSet<Integer> set = map.get(key);
			int i=0;
			for(Integer x:set){
				System.out.print(x);
				if(i==set.size()-1 || i%key==key-1)
					System.out.println();
				else
					System.out.print(" ");
				i++;
			}
		}
	}

	public static void main(String[] args) {
		socialGraphs(new int[]{2,1,1,2,1});
	}
}
