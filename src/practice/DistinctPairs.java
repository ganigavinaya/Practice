package practice;

import java.util.HashMap;
import java.util.HashSet;

public class DistinctPairs {

	static int distinctPairs(int[] arr, int target){

		HashMap<Integer,Integer> map = new HashMap<>();

		HashSet<String> set = new HashSet<>();

		for(int i=0;i<arr.length;i++){
			map.put(arr[i],map.getOrDefault(arr[i],0)+1);
		}


		for(Integer x:map.keySet()){
			int diff = target-x;
			Integer b = map.get(diff);
			if(b!=null && b>0){
				if(x==diff){
					if(b<2)
						continue;
					set.add(x+" "+x);
				}
				else if(x<diff) {
					set.add(x+" "+diff);
				}
				else{
					set.add(diff+" "+x);
				}
				map.put(diff,b-1);
				map.put(x,map.get(x)-1);
			}
		}

		return set.size();
	}

	public static void main(String[] args) {
		System.out.println(distinctPairs(new int[]{6,6,12,3,9,3,5,1},12));
	}
}
