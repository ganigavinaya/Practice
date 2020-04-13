package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {	
    
	class DSU {
	    int[] parent;
	    public DSU() {
	        parent = new int[10001];
	        for (int i = 0; i <= 10000; ++i)
	            parent[i] = i;
	    }
	    public int find(int x) {
	        if (parent[x] != x) parent[x] = find(parent[x]);
	        return parent[x];
	    }
	    public void union(int x, int y) {
	        parent[find(x)] = find(y);
	    }
	}
	
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        DSU dsu = new DSU();
        
        Map<String,Integer> idMap = new HashMap<>();
        Map<String,String> nameMap = new HashMap<>();
        
        int counter = 0;
        for(List<String> acc:accounts) {
        	String name = acc.remove(0);        	
        	for(String email:acc) {
        		nameMap.put(email, name);
        		if(!idMap.containsKey(email)) {
        			idMap.put(email, counter++);
        		}
        		dsu.union(idMap.get(email) , idMap.get(acc.get(1)));
        	}        	
        }
        
        Map<Integer, List<String>> ans = new HashMap<>();
        for (String email: nameMap.keySet()) {
            int index = dsu.find(idMap.get(email));
            ans.computeIfAbsent(index, x-> new ArrayList<>()).add(email);
        }
        for (List<String> component: ans.values()) {
            Collections.sort(component);
            component.add(0, nameMap.get(component.get(0)));
        }

        return new ArrayList<>(ans.values());

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
