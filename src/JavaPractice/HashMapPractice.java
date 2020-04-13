package JavaPractice;

import java.util.*;

public class HashMapPractice {

	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<>();


		for(int i=0,j=10;i<10;i++,j++){
			map.put(i,j);
		}

		Set<Integer> keys = map.keySet();

		for(Integer key:keys){
			System.out.println(map.get(key));
		}

		for(Map.Entry<Integer,Integer> e:map.entrySet()){
			System.out.println(e.getKey()+" "+e.getValue());
		}

		Set<Integer> arr = new HashSet<>(map.values());
	}
}
