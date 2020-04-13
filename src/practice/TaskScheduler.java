package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> taskCountMap =new HashMap<>();

		for(char t:tasks) {
			taskCountMap.compute(t, (K,V)-> (V == null ? 1 : V + 1));
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		queue.addAll(taskCountMap.values());

		int result = 0;
		while(!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<=n;i++) {
				if(!queue.isEmpty()) {
					Integer count = queue.poll();
					if (count > 1) {
						list.add(count-1);
					}
				}
				result++;
				if(queue.isEmpty() && list.isEmpty()) {
					return result;
				}
			}
			queue.addAll(list);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(leastInterval(new char[] {'A','A','A','B','B','B'}, 2));
	}
}
