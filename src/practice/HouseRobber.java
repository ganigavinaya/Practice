package practice;

public class HouseRobber {

	public int rob(int[] nums) {
        int max = 0;
        int[] money = new int[nums.length];
        if(nums.length==1)
        		return nums[0];
        
        money[0]=nums[0];
        money[1]=nums[1];
        max = Math.max(nums[0], nums[1]);
        
        if(nums.length==2) {
    			return max;
        }
        
        for(int i=2;i<nums.length;i++) {
        		money[i] = Math.max(money[i-2]+nums[i],money[i-1]);
        		if(max<money[i]) {
        			max = money[i];
        		}
        }
        
        return max;
    }

	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.rob(new int[] {1,4,2,3,8,6,5}));

	}

}
