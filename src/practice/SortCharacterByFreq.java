package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SortCharacterByFreq {

	public class Node{
		char c;
		int count;
		
		public Node(char c,int count){
			this.c = c;
			this.count =count;
		}
	}
	public String frequencySort(String s) {
        if(s.length()==0)
            return "";
        
        HashMap<Character,Node> map = new HashMap<>();
        
        char[] sArr = s.toCharArray();
        
        for(char c:sArr){
        		Node val = map.get(c);
            if(val==null)
                map.put(c,new Node(c,1));
            else
                val.count++;
        }
        
        List<Node> valArr = new ArrayList<>(map.values());
        
        valArr.sort(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {				
				return o2.count-o1.count;
			}

			
		});
        
        StringBuilder str = new StringBuilder();
        for(Node n:valArr) {
        		for(int i=0;i<n.count;i++) {
        			str.append(n.c);
        		}
        }
        return str.toString();
    }
	
	public static void main(String[] args) {
		SortCharacterByFreq sf = new SortCharacterByFreq();
		System.out.println(sf.frequencySort("tree"));
	}

}
