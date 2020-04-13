package practice;
import java.util.*;


public class MeetingRooms {

	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public int minMeetingRooms(Interval[] intervals) {
		
		if(intervals.length==0)
			return 0;        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        Arrays.sort(intervals, (o1, o2) -> (o1.start-o2.start));
        
        pq.add(intervals[0].end);
        for(int i=1;i<intervals.length;i++) {        		
        		Integer endTime = pq.peek();
    			if(intervals[i].start>endTime) {
    				pq.remove();
    			}
    			pq.add(intervals[i].end);    			
        }
        
        return pq.size();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
