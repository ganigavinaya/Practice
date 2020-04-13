package practice;

import java.util.HashSet;

public class MGroupsKSize {

	class Node {
		int min,max;
		Node left=null,right=null;
	}
	
	int findLatestKGroup(int[] A, int K, int M){
		Node head = new Node();
		head.min = head.max = A[0];		
		
		HashSet<Integer> set = new HashSet<>();
		
		int latest = -1;
		if(K==1 && M==1) {
			set.add(head.min);
			latest = 1;
		}

		for(int i=1;i<A.length;i++) {
			
			Node temp = head;
			
			while(true) {	
				if(A[i]>temp.max+1) {
					if(temp.right==null) {
						temp.right = new Node();
						temp.right.max = temp.right.min = A[i];
						
						if(K==1)
							set.add(temp.right.min);
						break;
					}
					else {
						temp = temp.right;
					}
				}
				else if(A[i]==temp.max+1) {
					if(temp.right!=null) {
						Node findLeft = temp.right;
						Node prev = null;
						temp.max++;
						while(findLeft!=null && findLeft.min!=temp.max+1) {	
							prev = findLeft;
							findLeft = findLeft.left;							
						}
						
						if(findLeft!=null) {
							if(prev!=null)
								prev.left = null;
							temp.max = findLeft.max;
							set.remove(findLeft.min);
						}
						else {
							temp.max = temp.right.max;						
							set.remove(temp.right.min);
							temp.right=null;
						}
					}
					else {
						temp.max++;
					}
					
					if(K<=(temp.max-temp.min+1))
						set.add(temp.min);
					else {
						set.remove(temp.min);
					}
					break;
				}
				else if(A[i]<temp.min-1) {
					if(temp.left==null) {
						temp.left = new Node();
						temp.left.max = temp.left.min = A[i];
						
						if(K==1)
							set.add(temp.left.min);
						break;
					}
					else {
						temp = temp.left;
					}
				}
				else if(A[i]==temp.min-1) {
					set.remove(temp.min);
					if(temp.left!=null && temp.left.max==A[i]-1) {
						temp.min--;
						Node findRight = temp.left;
						Node prev = null;
						while(findRight!=null && findRight.max!=temp.min-1) {	
							prev = findRight;
							findRight = findRight.right;							
						}
						
						if(findRight!=null) {
							if(prev!=null)
								prev.right = null;
							temp.min = findRight.min;
							set.remove(findRight.min);
						}
						else {
							temp.min = temp.left.min;						
							temp.left=null;
						}
					}
					else {
						temp.min--;
					}					
					
					if(K<=(temp.max-temp.min+1))
						set.add(temp.min);
					
					break;
				}
				
			}
			if(set.size()==M)
				latest = i+1;
		}
		
		return latest;
	}
	
	public static void main(String[] args) {
		MGroupsKSize mg = new MGroupsKSize();
		
		System.out.println(mg.findLatestKGroup(new int[] {1,4,3,2,5}, 1,3));
	}

}
