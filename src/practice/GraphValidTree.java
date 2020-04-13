package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphValidTree {

	class Node{
		List<Integer> adjList = new ArrayList<>();
		boolean seen=false;
		int parent = -1;
	}
	
	HashMap<Integer,Node> map = new HashMap<>();
	
	boolean dfs(int start) {
		Node n = map.get(start);
		if(n!=null) {
			n.seen=true;
			for(int i:n.adjList) {
				Node adjV = map.get(i);
				if(n.parent!=i) {
					if(adjV.seen)
						return false;
					adjV.parent=start;
					if(!dfs(i))
						return false;
				}
			}
		}
		return true;
	}
	
	public boolean validTree(int n, int[][] edges) {
		if(edges.length==0)
			if(n<=1)
				return true;
			else
				return false;
		
		for(int[] edge:edges) {
			Node n1 = map.get(edge[0]);
			if(n1==null) {
				n1 = new Node();
				map.put(edge[0], n1);				
			}
			n1.adjList.add(edge[1]);
			
			Node n2 = map.get(edge[1]);
			if(n2==null) {
				n2 = new Node();
				map.put(edge[1], n2);				
			}
			n2.adjList.add(edge[0]);
		}
		boolean result = map.size()==n;
		if(result)
			result = dfs(edges[0][0]);
		
		if(result) {
			for(Node val:map.values()) {
				if(!val.seen) {
					result = false;
					break;
				}
			}
		}
        return result;
    }
	
	public static void main(String[] args) {
		GraphValidTree gv = new GraphValidTree();
		System.out.println(gv.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
	}

}
