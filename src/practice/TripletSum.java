package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {
	
	public List<List<Integer>> threeSum(int[] nums) {
	        
        List<List<Integer>> result = new ArrayList<>();

        if(nums.length<=0 || nums==null){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || nums[i]>nums[i-1]) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        result.add(temp);
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    } else if (nums[i] + nums[j] + nums[k] > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }

            }

        }

        return result;
    }
	 
	public static void main(String[] args) {
		TripletSum ts = new TripletSum();
		ts.threeSum(new int[] {-1, 0, 1, 2, -1, -4});

	}

}
