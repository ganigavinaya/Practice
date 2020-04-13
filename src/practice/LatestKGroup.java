package practice;

import java.util.HashSet;

public class LatestKGroup {
	class Node {
		int min,max;
		Node left=null,right=null;
	}
	
	int findLatestKGroup(int[] days, int K){
		Node head = new Node();
		head.min = head.max = days[0];		
		
		HashSet<Integer> set = new HashSet<>();
		
		int latest = -1;
		if(K==1) {
			set.add(head.min);
			latest = 1;
		}

		for(int i=1;i<days.length;i++) {
			
			Node temp = head;
			
			while(true) {	
				if(days[i]>temp.max+1) {
					if(temp.right==null) {
						temp.right = new Node();
						temp.right.max = temp.right.min = days[i];
						
						if(K==1)
							set.add(temp.right.min);
						break;
					}
					else {
						temp = temp.right;
					}
				}
				else if(days[i]==temp.max+1) {
					if(temp.right!=null && temp.right.min==days[i]+1) {
						temp.max = temp.right.max;						
						set.remove(temp.right.min);
						temp.right=null;
					}
					else {
						temp.max++;
					}
					
					if(K==(temp.max-temp.min+1))
						set.add(temp.min);
					else {
						set.remove(temp.min);
					}
					break;
				}
				else if(days[i]<temp.min-1) {
					if(temp.left==null) {
						temp.left = new Node();
						temp.left.max = temp.left.min = days[i];
						
						if(K==1)
							set.add(temp.left.min);
						break;
					}
					else {
						temp = temp.left;
					}
				}
				else if(days[i]==temp.min-1) {
					set.remove(temp.min);
					if(temp.left!=null && temp.left.max==days[i]-1) {
						temp.min = temp.left.min;						
						temp.left=null;
					}
					else {
						temp.min--;
					}					
					
					if(K==(temp.max-temp.min+1))
						set.add(temp.min);
					
					break;
				}
				
			}
			if(!set.isEmpty())
				latest = i+1;
		}
		
		return latest;
	}
	
	public static void main(String[] args) {
		LatestKGroup lk = new LatestKGroup();
		
		System.out.println(lk.findLatestKGroup(new int[] {1,2,6,3,5,4}, 3));

	}

}
