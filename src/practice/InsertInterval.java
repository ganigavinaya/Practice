package practice;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	
	public static class Interval {
		int start;
		int end;
		Interval() {
			start = 0; end = 0; 
		}
		Interval(int s, int e) {
			start = s; end = e; 
		}
	}
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        boolean added = false;
        for(Interval x: intervals){
            if(x.end<newInterval.start){
                res.add(x);
            }
            else{
            	if(x.start<newInterval.start) {
	            	newInterval.start = x.start;
	            }
            	if(x.end>=newInterval.end) {
            		if(x.start<=newInterval.end)
            			newInterval.end = x.end;
            		else
            			res.add(x);
            		if(!added) {
            			res.add(newInterval);
            			added = true;
            		}
            	}
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		List<Interval> input = new ArrayList<>();
		input.add(new Interval(1,2));
		input.add(new Interval(3,5));
		input.add(new Interval(6,7));
//		input.add(new Interval(8,10));
		input.add(new Interval(12,16));
		InsertInterval.insert(input, new Interval(8,10));
	}

}
