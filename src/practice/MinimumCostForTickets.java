package practice;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {
	private int[] costs;
	private int[] memo;
	private Set<Integer> daySet;

	public int minCostTickets(int[] days, int[] costs) {
		this.costs = costs;
		memo = new int[days[days.length-1]+1];
		daySet = new HashSet<>();
		for (int d : days) daySet.add(d);

		return dp(1);
	}

	private int dp(int i) {
		if (i>=memo.length) {
			return 0;
		}
		if (memo[i] > 0)
			return memo[i];

		int ans;
		if (daySet.contains(i)) {
			ans = Math.min(dp(i + 1) + costs[0],
					dp(i + 7) + costs[1]);
			ans = Math.min(ans, dp(i + 30) + costs[2]);
		} else {
			ans = dp(i + 1);
		}

		memo[i] = ans;
		return ans;
	}

	public static void main(String[] args) {
		MinimumCostForTickets minimumCostForTickets = new MinimumCostForTickets();
		System.out.println(minimumCostForTickets.minCostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
	}

}
