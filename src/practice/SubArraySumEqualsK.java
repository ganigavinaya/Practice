package practice;

public class SubArraySumEqualsK {

	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		
		int[] sum = new int[nums.length];
		
		for(int i=0;i<nums.length;i++) {	
			sum[i]=nums[i];
			for(int j=i+1;j<nums.length;j++) {
				if(i==0)
					sum[j]=sum[j-1]+nums[j];	
				else
					sum[j]=sum[j]-nums[i-1];
				if(sum[j]==k)
					count++;
			}
					
		}
		
        return count;
    }

	public static void main(String[] args) {
		subarraySum(new int[] {1}, 0);

	}

}
