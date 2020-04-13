package practice;

import java.util.ArrayList;
import java.util.List;

public class DuplicatedInArray {

	 public static List<Integer> findDuplicates(int[] nums) {
	        List<Integer> arr = new ArrayList<>();
	        
	        for(int i=0;i<nums.length;i++){
	            
	            if(nums[Math.abs(nums[i])-1]<=0){
	                arr.add(Math.abs(nums[i]));
	            }
	            else{
	                nums[Math.abs(nums[i])-1]*=-1;  
	            }
	        }
	        
	        return arr;
	    }
	 
	public static void main(String[] args) {
		findDuplicates(new int[] {4,3,2,7,8,2,3,1} );

	}

}
