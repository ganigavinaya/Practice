package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
        LinkedList<String> result = new LinkedList<>();
        
        if(nums.length==1) {
        		result.add(nums[0]+"");
        		return result;
        }
        
       
        for(int i=0;i<nums.length;i++) {   
        		if(result.isEmpty())
        			result.add(nums[i]+"");   
        		else {
        			String prev = result.getLast();
        			String[] splitPrev = prev.split("->");

    				if((splitPrev.length<2 && nums[i]-Integer.parseInt(splitPrev[0])==1) || 
    					(splitPrev.length==2 && nums[i]-Integer.parseInt(splitPrev[1])==1)) {
    					result.removeLast();
    					result.add(splitPrev[0]+"->"+nums[i]);
    				}
    				else {
    					result.add(nums[i]+"");
    				}

        		}
        }
        	
        	return result;
    }
	
	public static void main(String[] args) {
		SummaryRanges sr = new SummaryRanges();
		List<String> l = sr.summaryRanges(new int[]{});
		System.out.println(Arrays.toString(l.toArray()));
	}

}
