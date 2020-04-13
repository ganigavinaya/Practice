package practice;

import java.util.List;
import java.util.ArrayList;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		
        int total = (int) Math.pow(2,nums.length);
		for(int i=0;i<total;i++) {
			List<Integer> temp = new ArrayList<>();
			for(int j=0;j<nums.length;j++) {
				if ((i & (1 << j)) > 0)
					temp.add(nums[j]);
			}
			res.add(temp);
		}
        
		return res;
    }

	public static void main(String[] args) {
		Subsets s = new Subsets();
		s.subsets(new int[]{1,2,3});

	}

}
