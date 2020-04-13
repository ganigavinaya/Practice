package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationWithDuplicatesEntries {
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		 List<List<Integer>> result = new ArrayList<>();
		
		 if(nums.length==0)
			 return result;
		 Arrays.sort(nums);
		 
		 List<Integer> input = new ArrayList<>();
		
		 for(int i:nums) {
			 input.add(i);
		 }
		 result.add(new ArrayList<>(input));
		 if(input.size()==1)
			 return result;
		 
		 while(true) {
			 int j=input.size()-2;
			 while(j>=0 && input.get(j)>=input.get(j+1)) {
				 j--;
			 }
			 if(j<0)
				 break;
			 
			 int k=input.size()-1;
			 
			 while(input.get(j)>=input.get(k)) {
				 k--;
			 }
			 
			 if(j!=k) {
				 int temp = input.get(j);
				 input.set(j, input.get(k));
				 input.set(k, temp);
			 }
			 
			 for(int i=j+1, l=input.size()-1;i<=l;i++,l--) {
				 int temp = input.get(i);
				 input.set(i, input.get(l));
				 input.set(l, temp);
			 }
			 
			 result.add(new ArrayList<>(input));
		 }
		 return result;
	}
	 
	public static void main(String[] args) {
		PermutationWithDuplicatesEntries pp = new PermutationWithDuplicatesEntries();
		pp.permuteUnique(new int[] {1,2,3});

	}

}
