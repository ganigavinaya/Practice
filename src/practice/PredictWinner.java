package practice;

public class PredictWinner {

//	int bestMove(int[] nums, int s, int e) {
//		if(s>e)
//			return 0;
//		if(s==e)
//			return nums[s];
//		else {
//			int res1 = bestMove(nums,s+1,e);
//			int res2 = bestMove(nums,s,e-1);
//			if(res1>res2)
//				return res1+nums[s];
//			else
//				return res2+nums[e];
//		}
//	}
//	
//	public boolean PredictTheWinner(int[] nums) {
//        return true;
//    }
	
	public static boolean PredictTheWinner(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return winner(nums, 0, nums.length - 1, memo) >= 0;
    }
    public static int winner(int[] nums, int s, int e, Integer[][] memo) {
        if (s == e)
            return nums[s];
        if (memo[s][e] != null)
            return memo[s][e];
        int a = nums[s] - winner(nums, s + 1, e, memo);
        int b = nums[e] - winner(nums, s, e - 1, memo);
        memo[s][e] = Math.max(a, b);
        return memo[s][e];
    }

	public static void main(String[] args) {
		PredictTheWinner(new int[] {1,5,233,7});

	}

}
