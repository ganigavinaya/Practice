package practice;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
	static Map<Integer,Integer>[] dp;

	private static int dfs(int[] nums, int i, int target){
		if(i>=nums.length){
			if(target == 0){
				return 1;
			} else {
				return 0;
			}
		}

		if(!dp[i].containsKey(target)){
			int result = dfs(nums, i+1, target-nums[i]) + dfs(nums, i+1, target+nums[i]);
			dp[i].put(target, result);
		}

		return dp[i].get(target);
	}

	public static int findTargetSumWays(int[] nums, int S) {
		dp = new HashMap[nums.length];

		for(int i=0;i<nums.length;i++){
			dp[i] = new HashMap<Integer, Integer>();
		}

		return dfs(nums, 0, S);
	}

	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
	}
}
