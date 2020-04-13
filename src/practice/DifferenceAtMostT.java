package practice;

import java.util.TreeSet;

public class DifferenceAtMostT {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums.length==0)
			return false;
		TreeSet<Integer> set = new TreeSet<>();
		
		for(int i=0;i<nums.length;i++) {
			Integer s = set.ceiling(nums[i]);
			
			if(s!=null && s<=t+nums[i])
				return true;
			
			s = set.floor(nums[i]);
			if(s!=null && nums[i]<=t+s)
				return true;
			
			set.add(nums[i]);
			if(set.size()>k)
				set.remove(nums[i-k]);
		}
		return false;
    }

	public static void main(String[] args) {
		DifferenceAtMostT dt = new DifferenceAtMostT();
		System.out.println(dt.containsNearbyAlmostDuplicate(new int[] {-1,2147483647},1,2147483647));

	}

}
