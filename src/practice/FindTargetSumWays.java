package practice;

public class FindTargetSumWays {

	public int findTargetSumWays(int[] nums, int S) {
        return findTargetRec(nums,0,S);
    }
    
    private int findTargetRec(int[] nums, int start, int S){
        
        if(start>=nums.length)
            return 0;
        if(start==nums.length-1){
            if((S-nums[start]==0) || (S+nums[start]==0))
                return 1;
        }
        int pos = findTargetRec(nums,start+1,S-nums[start]); //positive
        int neg = findTargetRec(nums,start+1,S+nums[start]); //negative
        return pos+neg;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindTargetSumWays ft = new FindTargetSumWays();
		ft.findTargetSumWays(new int[] {1,1,1,1}, 2);
	}

}
