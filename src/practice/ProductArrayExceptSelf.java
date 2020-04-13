package practice;

import java.util.Arrays;

public class ProductArrayExceptSelf {
	public static int[] productExceptSelf(int[] nums){
		int[] result = new int[nums.length];

		int prod = 1;
		for(int i=0;i<nums.length;i++){
			result[i]=prod;
			prod*=nums[i];
		}

		prod = 1;
		for(int i=nums.length-1;i>=0;i--){
			result[i]*=prod;
			prod*=nums[i];
		}


		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int[]{2,3,4,5})));
	}
}
