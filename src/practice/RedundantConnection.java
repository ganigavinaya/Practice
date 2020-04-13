package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RedundantConnection {

	class Node{
		List<Integer> adjList = new ArrayList<>();
		boolean seen=false;
		int parent=0;
	}
	
	HashMap<Integer, Node> map = new HashMap<>();
	
	int dfs(Integer start,LinkedList<Integer[]> list) {
		Node v = map.get(start);
		
		if(v!=null) {
			v.seen=true;
			
			for(Integer conn:v.adjList) {
				Node adjV = map.get(conn);
				if(v.parent!=conn) {
					if(conn>start)
						list.add(new Integer[] {start,conn});
					else
						list.add(new Integer[] {conn,start});
					if(adjV.seen) {
						return start;
					}
					else {
						adjV.parent=start;						
						int returnVal = dfs(conn,list);
						if(returnVal!=0){
							return returnVal;
						}
					}	
				}
			}
			list.removeLast();
		}
		
		return 0;
		
	}
	public int[] findRedundantConnection(int[][] edges) {
		
		for(int i=0;i<edges.length;i++) {
			Node n1 = map.get(edges[i][0]);
			if(n1==null) {
				n1 = new Node();				
			}
			n1.adjList.add(edges[i][1]);
			map.put(edges[i][0], n1);
			
			Node n2 = map.get(edges[i][1]);
			if(n2==null) {
				n2 = new Node();
			}
			n2.adjList.add(edges[i][0]);
			map.put(edges[i][1], n2);
			
		}
		LinkedList<Integer[]> list = new LinkedList<>();		
		int cycle = dfs(edges[0][0],list);
		Integer[] arr = list.removeLast();
		int target =arr[0]==cycle?arr[1]:arr[0];
		
		int i=edges.length-1;
		for(;i>=0;i--) {
			if(edges[i][0]==arr[0] && edges[i][1]==arr[1])
				break;
		}
		int max = i;
		
		while(!list.isEmpty()) {
			arr = list.removeLast();
			if(arr[0]==target || arr[1]==target)
				break;
			i=edges.length-1;
			for(;i>=0;i--) {
				if(edges[i][0]==arr[0] && edges[i][1]==arr[1])
					break;
			}
			max = Math.max(max, i);
			
		}

        return edges[max];
    }

	public static void main(String[] args) {
		RedundantConnection rc = new RedundantConnection();
		int[] result = rc.findRedundantConnection(new int[][] {{2,7},{7,8},{3,6},{2,5},{6,8},{4,8},{2,8},{1,8},{7,10},{3,9}});
		System.out.println(Arrays.toString(result));
	}

}
