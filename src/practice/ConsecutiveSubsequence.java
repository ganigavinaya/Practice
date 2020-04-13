package practice;

import java.util.HashMap;

public class ConsecutiveSubsequence {

	public static boolean isPossible(int[] nums) {
        if(nums.length<3)
            return false;
        
        HashMap<Integer,Integer> counter = new HashMap<>();
        HashMap<Integer,Integer> end = new HashMap<>();
        
        for(Integer i:nums) {
        		Integer val = counter.get(i);
        		if(val==null) {
        			counter.put(i, 1);
        		}
        		else {
        			counter.put(i,val+1);
        		}
        }
        
        for(Integer i:nums) {
        		Integer val = counter.get(i);
        		Integer endVal = end.get(i);
        		Integer nextVal = counter.get(i+1);
        		Integer nextNextVal = counter.get(i+2);
        		
        		if(val==0) {
        			continue;
        		}
        		else if(endVal!=null && endVal>0) {
        			end.put(i, endVal-1);
        			Integer nextEndVal = end.get(i+1);
        			if(nextEndVal!=null) {
        				end.put(i+1, nextEndVal+1);
        			}
        			else
        				end.put(i+1, 1);
        		}
        		else if(nextVal!=null && nextNextVal!=null && nextVal>0 && nextNextVal>0) {
        			counter.put(i+1,nextVal-1);
        			counter.put(i+2,nextNextVal-1);
        			Integer nextEndVal = end.get(i+3);
        			if(nextEndVal!=null)
        				end.put(i+3, nextEndVal+1);
        			else {
        				end.put(i+3, 1);
        			}
        		}
        		else {
        			return false;
        		}
        		counter.put(i,val-1);
        }
	    
	    return true;
    }
	
	public static void main(String[] args) {
		System.out.println(isPossible(new int[] {1,2,3,3,4,4,5,5}));
	}

}
