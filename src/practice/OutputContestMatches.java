package practice;

import java.util.LinkedList;

public class OutputContestMatches {
	
	public static String findContestMatch(int n) {
		LinkedList<String> curr = new LinkedList<>();
        for(int i=1;i<=n;i++) {
        	curr.add(String.valueOf(i));
        }
        LinkedList<String> next = new LinkedList<>();

		do {
			while(curr.size()>1) {
				next.add("("+curr.removeFirst()+","+curr.removeLast()+")");
			}
			if(curr.size()==1)
				return curr.getFirst();
			
			curr = new LinkedList<>(next);
			next.clear();
		}while(!curr.isEmpty());
		return "";
    }

	public static void main(String[] args) {
		System.out.println(findContestMatch(8));
	}

}
