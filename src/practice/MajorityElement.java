package practice;

public class MajorityElement {

	int countMajority(int[] nums,int s, int e, int x) {
		int count = 0;
		for(;s<=e;s++)
			if(nums[s]==x)
				count++;
		return count;
	}
	int findMajorityRec(int[] nums,int s, int e){
		//[1,2,1,5,1,1]
		if(s==e)
			return nums[s];
		
		int mid = (s+e)/2;
		int left = findMajorityRec(nums, s, mid);
		int right = findMajorityRec(nums, mid+1, e);
		
		if(left==right)
			return left;
		
		return countMajority(nums, s, mid, left)>countMajority(nums, mid+1, e, right)?left:right;
	}
	
	public int majorityElement(int[] nums) {
		if(nums.length==0)
            return 0;
        return findMajorityRec(nums,0,nums.length-1);
    }

	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		System.out.println(me.majorityElement(new int[] {1,2,3,1,1,4,1,5,1}));

	}

}
