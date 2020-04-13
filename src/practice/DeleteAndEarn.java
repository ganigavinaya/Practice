package practice;

import java.util.ArrayList;
import java.util.TreeMap;

public class DeleteAndEarn {

	public int deleteAndEarn(int[] nums) {
        if(nums.length==1)
            return nums[0];
        
        
            
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i:nums){
            Integer val = map.get(i);
            if(val==null){
                map.put(i,i);
            }
            else{
                map.put(i,val+i);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>(map.keySet());
        int[] matrix = new int[map.size()];
        
        matrix[0]=map.get(arr.get(0));

        if(arr.get(1)-arr.get(0)==1){
            matrix[1]=Math.max(matrix[0],map.get(arr.get(1)));
        }
        else{
            matrix[1] = matrix[0]+map.get(arr.get(1));
        }
        
       
        for(int i=2;i<arr.size();i++){
            int key = arr.get(i);
            int val = map.get(key);
 
            if((key-arr.get(i-1)) == 1){
            		matrix[i] = Math.max(matrix[i-2]+val,matrix[i-1]);
            }
            else{
            		matrix[i]= matrix[i-1]+val;
            }
            
        }
        
        return matrix[arr.size()-1];
    }
	public static void main(String[] args) {
		DeleteAndEarn de = new DeleteAndEarn();
		//int sum = de.deleteAndEarn(new int[] {21,76,54,72,30,94,20,72,21,65,80,31,94,76,34,53,62,25,81,79,58,24,99,15,46,63,10,11,50,19,91,44,56,86,35,76,22,52});
		int sum = de.deleteAndEarn(new int[] {21,76,54,72,30,94,20,72,21,65,80,31,94,76,34,53,62,25,81,79,58,24,99,15,46,63,10,11,50,19,91,44,56,86,35,76,22,52});
		System.out.println(sum);
	}

}
