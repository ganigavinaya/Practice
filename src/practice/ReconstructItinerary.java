package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class ReconstructItinerary {


	HashMap<String,List<String>> map = new HashMap<>();
	
	int ticketsUsed = 0;
	int totalTickets = 0;
	
	void dfs(String start,LinkedList<String> result) {
		List<String> connection = map.get(start);
		if(connection==null)
			return;

		for(int i=0;i<connection.size();i++) {
			String c = connection.get(i);
			connection.remove(i);
			result.add(c);
			ticketsUsed++;
			dfs(c,result);
			if(ticketsUsed==totalTickets)
				return;
			result.removeLast();
			ticketsUsed--;
			connection.add(i,c);
		}
		
	}
	public List<String> findItinerary(String[][] tickets) {
		totalTickets = tickets.length;
		for(int i=0;i<tickets.length;i++) {
			
			List<String> n1 = map.get(tickets[i][0]);
			if(n1==null) {
				n1 = new ArrayList<>();
				map.put(tickets[i][0], n1);
			}
			n1.add(tickets[i][1]);
		
			
		}		
		
		for(Entry<String,List<String>> e:map.entrySet()) {
			Collections.sort(e.getValue());
		}
		LinkedList<String> result = new LinkedList<>();
		result.add("JFK");
		dfs("JFK",result);
		return result;
    }

	public static void main(String[] args) {
		ReconstructItinerary it = new ReconstructItinerary();
		List<String> result = it.findItinerary(new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}});
		System.out.println(result.toString());
	}

}
