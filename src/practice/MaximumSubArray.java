package practice;

public class MaximumSubArray {

	public int maxSubArray(int[] nums) {
		
		int[] sum = new int[nums.length];
		int n = nums.length;
		sum[0]=nums[0];
		int max = sum[0];
		
		for(int i=1;i<n;i++) {
			sum[i] = Math.max(nums[i], sum[i-1]+nums[i]);
			if(max<sum[i])
				max = sum[i];
		}
		
		return max;
	}
	 
	public static void main(String[] args) {
		MaximumSubArray ms = new MaximumSubArray();
		System.out.println(ms.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));

	}

}
