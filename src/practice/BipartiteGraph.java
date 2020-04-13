package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BipartiteGraph {
	int[][] graph;

	private boolean assignGroup(
			Map<Integer, Boolean> map,
			int i,
			Integer parent
	){
		boolean currentGroup = map.get(i);
		for(int j : graph[i]){
			if (parent!=null && j == parent)
				continue;

			Boolean result = map.compute(j, (K, V) -> {
				if (V == null) {
					map.put(K, !currentGroup);
					return null;
				} else {
					return V != currentGroup;
				}
			});

			if(result == null){
				if(!assignGroup(map, j, i)) {
					return false;
				}
			} else if(!result) {
				return false;
			}
		}
		return true;
	}
	public boolean isBipartite(int[][] graph) {
		this.graph = graph;
		Map<Integer, Boolean> map = new HashMap<>();

		for(int i=0;i<graph.length;i++){
			if(map.containsKey(i)){
				continue;
			}
			map.put(i, true);
			if(!assignGroup(map, i, null)){
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		BipartiteGraph b = new BipartiteGraph();
		System.out.println(b.isBipartite(new int[][]{{1}, {0,3}, {3}, {1,2}}));
	}
}
