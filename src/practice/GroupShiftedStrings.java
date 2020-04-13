package practice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {

	HashMap<String,List<String>> map = new HashMap<>();
	
	String getSequence(String s) {
		char[] arr=s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<arr.length;i++) {
			if(arr[i-1]<=arr[i]) {
				sb.append(arr[i]-arr[i-1]);
			}
			else {
				int rem=(26-arr[i-1])+arr[i];
				sb.append(rem);
			}
		}
		return sb.toString();
	}
	
	public List<List<String>> groupStrings(String[] strings) {
		
		for(String s:strings) {
			if(s.length()==1) {
				List<String> list = map.get("-1");
				if(list==null) {
					list=new ArrayList<>();		
					map.put("-1", list);
				}
				list.add(s);
			}
			else {
				String seq = getSequence(s);
				List<String> list = map.get(seq);
				if(list==null) {
					list=new ArrayList<>();		
					map.put(seq, list);
				}
				list.add(s);
			}
		}
		
		List<List<String>> result = new ArrayList<>();
		for(List<String> list:map.values()) {
			result.add(list);
		}
        return result;
    }

	public static void main(String[] args) {
		
	}

}
