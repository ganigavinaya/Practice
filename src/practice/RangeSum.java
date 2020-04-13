package practice;

public class RangeSum {
	class NumArray {

	    int[][] range;
	    public NumArray(int[] nums) {
	        range = new int[nums.length][nums.length];
	        
	        for(int i=0;i<nums.length;i++) {
	        		for(int j=i;j<nums.length;j++) {
	        			if(i==j) {
	        				range[i][j]=nums[i];
	        			}
	        			else {
	        				range[i][j]=range[i][j-1]+nums[j];
	        			}
	        		}
	        }
	    }
	    
	    public int sumRange(int i, int j) {
	    		if(i<=j)
	    			return range[i][j];
	    		else
	    			return 0;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
