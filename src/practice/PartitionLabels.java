package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class PartitionLabels {

	class Index{
		char c;
		int first;
		int last;
		
		Index(char c,int first){
			this.c=c;
			this.first = first;
		}				
	}
	public List<Integer> partitionLabels(String S) {
		List<Integer> res =new ArrayList<>();
		
		char[] input = S.toCharArray();
		LinkedHashMap<Character,Index> map = new LinkedHashMap<>();
		
		for(int i=0;i<input.length;i++) {
			Index in = map.get(input[i]);
			if(in==null) {
				in = new Index(input[i],i);
				map.put(input[i], in);
			}
			in.last=i;			
		}
						
		int low =0, high=0;
		for(Entry<Character,Index> e:map.entrySet()) {			
			Index in = e.getValue();
			if(in.first>=low && in.first<=high) {
				high = Math.max(in.last, high);
			}
			else {
				res.add(high-low+1);
				low =in.first;
				high=in.last;
			}
		}
		res.add(high-low+1);
		return res;
    }

	public static void main(String[] args) {
		PartitionLabels pl = new PartitionLabels();
		List<Integer> res = pl.partitionLabels("ababcbacadefegdehijhklij");
		System.out.println(Arrays.toString(res.toArray()));

	}

}
