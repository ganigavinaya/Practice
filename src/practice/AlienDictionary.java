package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;


public class AlienDictionary {

	class Vertex{
		int inDegree=0;
		Set<Character> edge=new HashSet<>();
	}
	HashMap<Character,Vertex> map = new HashMap<>();
	
	
	public String alienOrder(String[] words) {
		
		if(words.length==0)
			return "";
		else if(words.length==1)
			return words[0];
			
		Set<Character> distinct = new HashSet<>();
		
		char[] first = words[0].toCharArray();
		
		for(int i=1;i<words.length;i++) {
			
			char[] sec = words[i].toCharArray();
			boolean added = false;
			
			for(int j=0;j<Math.max(first.length, sec.length);j++) {
				if(!added &&j<first.length && j<sec.length && first[j]!=sec[j])
				{					
					Vertex v=map.get(first[j]);
					if(v==null) {
						v=new Vertex();
						v.edge.add(sec[j]);
						map.put(first[j], v);
					}
					else {
						if(!v.edge.contains(sec[j]))
							v.edge.add(sec[j]);
						else {
							added = true;
							continue;
						}
					}

					v=map.get(sec[j]);
					if(v==null) {
						v=new Vertex();
						map.put(sec[j], v);
					}
					v.inDegree++;
					
					added = true;
					distinct.add(first[j]);
					distinct.add(sec[j]);
				}
				else {
					if(j<first.length)
						distinct.add(first[j]);
					if(j<sec.length )
						distinct.add(sec[j]);
				}
				
			}
			if(!added && first.length>sec.length)
				return "";			
			first = sec;
		}
		
		StringBuilder sb = new StringBuilder();
		Queue<Character> queue = new LinkedList<>();
		for(Entry<Character,Vertex> e:map.entrySet()) {
			if(e.getValue().inDegree==0)
				queue.add(e.getKey());
		}
		if(queue.isEmpty() && !map.isEmpty())
			return "";
		while(!queue.isEmpty()) {
			char key = queue.remove();
			Vertex v = map.get(key);
			sb.append(key);
			distinct.remove(key);
			for(char c:v.edge) {
				Vertex tempv = map.get(c);
				tempv.inDegree--;
				if(tempv.inDegree==0)
					queue.add(c);
			}
		}
		for(Entry<Character,Vertex> e:map.entrySet()) {
			if(e.getValue().inDegree!=0)
				return "";
		}
		if(sb.length()<distinct.size()) {
			for(char c:distinct)
				sb.append(c);
		}
		return sb.toString();
        
    }

	public static void main(String[] args) {
		AlienDictionary ad = new AlienDictionary();
		System.out.println(ad.alienOrder(new String[] {"za","zb","ca","cb"}));

	}

}
