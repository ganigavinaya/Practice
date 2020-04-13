package practice;

import java.util.Arrays;

public class FindTargetSumWaysto0 {

	public int findTargetSumWaysTo0(int[] nums) {        		
        int total = (int) Math.pow(2,nums.length);
        int res = 0;
        
		for(int i=0;i<total;i++) {
			int subsetSum = 0;
			boolean added = false;
			int[] temp = new int[nums.length];
			for(int j=0;j<nums.length;j++) {
				if ((i & (1 << j)) > 0) {
					subsetSum+=nums[j];
					temp[j]=nums[j];
					added =true;
				}
			}
			if(added && subsetSum==0) {
				res++;
				System.out.println(Arrays.toString(temp));
			}
		}
        
		return res;
    }
	
	
	//-5,-4,-1,1,2,4,5

    

	public static void main(String[] args) {
		FindTargetSumWaysto0 ft = new FindTargetSumWaysto0();
		System.out.println(ft.findTargetSumWaysTo0(new int[] {5,-5,1,4,-1,2,-4}));

	}

}
