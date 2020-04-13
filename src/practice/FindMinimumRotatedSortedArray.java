package practice;

public class FindMinimumRotatedSortedArray {
	private int findMinimum(int[] nums,int s, int e){
		if(s==e)
			return nums[s];
		if(nums[s]<nums[e])
			return nums[s];
		else {
			int mid = (s+e)/2;
			if(mid>0 && nums[mid]<nums[mid-1]) {
				return nums[mid];
			}
			if(mid<nums.length-1 && nums[mid]>nums[mid+1]) {
				return nums[mid+1];
			}
			return Math.min(findMinimum(nums, s, mid), findMinimum(nums, mid+1, e));
		}
	}
	
	public int findMin(int[] nums) {
		if(nums.length==1)
			return nums[0];
        return findMinimum(nums, 0, nums.length-1);
    }

	public static void main(String[] args) {
		FindMinimumRotatedSortedArray fa = new FindMinimumRotatedSortedArray();
		System.out.println(fa.findMin(new int[] {6,7,0,1,2,3,4,5}));
	}

}
