package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFreqWords {

	public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String w:words){
            map.compute(w, (x,y) -> (y == null? 1 : y+1));
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
            int c1 = map.get(s1);
            int c2 = map.get(s2);
            return c1==c2?s2.compareTo(s1):c1-c2;
        });
        
        for(String s:map.keySet()){
            pq.add(s);
            if(pq.size()>k)
                pq.remove();            
        }
        
        LinkedList<String> res= new LinkedList<>();
        while(pq.size()>0){
            res.addFirst(pq.remove());
        }
        
        return res;
    }
	
	public static void main(String[] args) {
        System.out.println(topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"},2));
	}

}
