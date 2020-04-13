package practice;

import java.util.HashMap;

public class ShortestDistanceFromAllBuildings {

	HashMap<String,HashMap<String,Integer>> dist = new HashMap<>();

	void dfs(int[][] grid,int tarI,int tarJ,int i, int j, int length, String target){
		if(tarI!=i || tarJ!=j){
			if(grid[i][j]!=0)
				return;
			String curr = i+" "+j;
			HashMap<String, Integer> map = dist.computeIfAbsent(curr, k -> new HashMap<>());
			length++;
			if(map.getOrDefault(target,length+1)>length){
				map.put(target,length);
			}
			else
				return;
		}
		if(i>0 && grid[i-1][j]==0){
			dfs(grid,tarI,tarJ,i-1,j,length,target);
		}
		if(i<grid.length-1 && grid[i+1][j]==0){
			dfs(grid,tarI,tarJ,i+1,j,length,target);
		}
		if(j>0 && grid[i][j-1]==0){
			dfs(grid,tarI,tarJ,i,j-1,length,target);
		}
		if(j<grid[i].length-1 && grid[i][j+1]==0){
			dfs(grid,tarI,tarJ,i,j+1,length,target);
		}


	}
	public int shortestDistance(int[][] grid) {

		int ones = 0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j]==1){
					dfs(grid,i,j,i,j,0,i+" "+j);
					ones++;
				}
			}
		}

		int min = Integer.MAX_VALUE;
		int total = 0;

		for(int i=0;i<grid.length;i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]==0){
					HashMap<String,Integer> map = dist.get(i+" "+j);
					if(map!=null && map.size()==ones){
						total = 0;
						for(Integer val:map.values()){
							total+=val;
						}

						min = Math.min(min,total);
					}
				}
			}
		}

		return total==0?-1:min;
	}

	public static void main(String[] args) {

		ShortestDistanceFromAllBuildings sd = new ShortestDistanceFromAllBuildings();
		System.out.println(sd.shortestDistance(
				new int[][]{{1,2,0}}));
//				new int[][]{{1,1,1,1,1,0},{0,0,0,0,0,1},{0,1,1,0,0,1},{1,0,0,1,0,1},{1,0,1,0,0,1},{1,0,0,0,0,1},{0,1,1,1,1,0}}));
				//new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}}));
	}
}
