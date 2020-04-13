package practice;

import java.util.ArrayList;
import java.util.Comparator;

//Greedy
public class MaxLengthPairChain {

	class Pair{
		int s;
		int f;
		Pair(int start,int finish){
			s=start;
			f=finish;
		}
	}
	public int findLongestChain(int[][] pairs) {
		if(pairs.length==0)
			return 0;
		ArrayList<Pair> input = new ArrayList<>();
        for(int i=0;i<pairs.length;i++) {
        	input.add(new Pair(pairs[i][0],pairs[i][1]));
        }
        
        int max = 1;
        input.sort(new Comparator<Pair>() {
        	public int compare(Pair p1,Pair p2) {
        		return p1.f-p2.f;
        	}
		});
        
        int prevF = input.get(0).f;
        for(int i=1;i<input.size();i++) {
        	Pair curr = input.get(i);
        	if(prevF<curr.s) {
        		max++;
        		prevF=curr.f;
        	}
        }
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
