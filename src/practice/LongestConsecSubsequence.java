package practice;

import java.util.HashMap;

public class LongestConsecSubsequence {

	int[] nums;
	int[] parent;
	int find(int i) {
		if(parent[i]==i)
			return i;
		else
			return find(parent[i]);
	}
	
	void union(int i,int j) {
		parent[find(j)]=find(i);	
	}
	
	public int longestConsecutive(int[] nums) {
		this.nums = nums;
		parent = new int[nums.length];
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for (int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i]))
				parent[i]=-1;
			else {
				map.put(nums[i], i);
				parent[i]=i;
			}				
		}
		
		for(int i=0;i<nums.length;i++) {
			if(parent[i]==-1)
				continue;
			Integer prevP = map.get(nums[i]-1);
			if(prevP!=null)
				union(prevP,i);
		}
		
		HashMap<Integer,Integer> countMap = new HashMap<>();
		int max = 0;
		for(int i=0;i<nums.length;i++) {
			if(parent[i]==-1)
				continue;
			parent[i]=find(parent[i]);
			Integer count = countMap.get(parent[i]);
			if(count==null) {
				count = 1;
			}
			else {
				count++;
			}
			countMap.put(parent[i], count);
			max = Math.max(max, count);
		}
		
		return max;
	}

	public static void main(String[] args) {
		LongestConsecSubsequence lcs = new LongestConsecSubsequence();
		
		lcs.longestConsecutive(new int[] {0,0,-1});
	}

}
