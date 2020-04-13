package practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MergeIntervals {

	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public List<Interval> merge(List<Interval> intervals) {
        TreeMap<Integer,Interval> map = new TreeMap<>();
        
        for(Interval i : intervals) {
        		Interval temp = map.get(i.start);
        		if(temp==null) {
        			map.put(i.start,i);
        		}
        		else {
        			if(temp.end<i.end) {
        				temp.end = i.end;
        			}
        		}
        }
                
        LinkedList<Interval> result = new LinkedList<>();
        
        for(Entry<Integer, Interval> e:map.entrySet()) {
        		Interval temp = e.getValue();
        		if(result.isEmpty() || result.getLast().end<temp.start) {
        			result.add(temp);
        		}
        		else {
        			result.getLast().end = Math.max(result.getLast().end, temp.end);
        		}
        }
        
		return result;
    }

	public static void main(String[] args) {
		
	}
}
