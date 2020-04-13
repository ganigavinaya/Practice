package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SequenceReconstruction {

	public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		if(org.length==0 || seqs.size()==0)
            return false;
		else if(org.length==1) {
			for(List<Integer> seq:seqs) {
	        	for(int i=0;i<seq.size();i++) {
	        		if(org[0]!=seq.get(i))
	        			return false;
	        	}
			}
			return true;
		}
		HashMap<String,Boolean> map = new HashMap<>();
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for(int i=0;i<org.length-1;i++) {
        	map.put(org[i]+" "+org[i+1], false);
        	indexMap.put(org[i], i);
        }        
        indexMap.put(org[org.length-1], org.length-1);
        
        for(List<Integer> seq:seqs) {
        	for(int i=0;i<seq.size()-1;i++) {
        		int first = seq.get(i);
        		int sec = seq.get(i+1);
        		if(!map.containsKey(first+" "+sec)){
        			Integer fIndex = indexMap.get(first);
        			Integer sIndex = indexMap.get(sec);
        			if(fIndex==null || sIndex==null || fIndex>sIndex)
        				return false;
        		}
        		else {
        			map.put(first+" "+sec,true);
        		}
        	}
        }
        
        Set<Boolean> res = new HashSet<>(map.values());
        return res.contains(true) && !res.contains(false);
    }

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		
		List<Integer> l2 = new ArrayList<>();
		l2.add(1);
		
		List<Integer> l3 = new ArrayList<>();
		l3.add(1);
		
		List<List<Integer>> res = new ArrayList<>();
		res.add(l1);
		res.add(l2);
		res.add(l3);
		System.out.println(sequenceReconstruction(new int[] {1}, res));

	}

}
