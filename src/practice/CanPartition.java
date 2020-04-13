package practice;

public class CanPartition {

	public boolean canPartition(int[] nums) {
        if(nums.length==0)
            return true;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        
        int target = sum/2;
        
        if(target*2!=sum)
            return false;
        
        int[][] matrix = new int[nums.length+1][target+1];
        
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=target;j++){
                if(nums[i-1]>j){
                    matrix[i][j]=matrix[i-1][j];
                }
                else{
                    matrix[i][j]=Math.max(nums[i-1]+matrix[i-1][j-nums[i-1]], matrix[i-1][j]);
                    if(matrix[i][j]==target)
                    		return true;
                }
            }
        }

        	return false;
    }
	
	public static void main(String[] args) {
		CanPartition cp = new CanPartition();
		System.out.println(cp.canPartition(new int[] {1, 5, 11, 5}));

	}

}
