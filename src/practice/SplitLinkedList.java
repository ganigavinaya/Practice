package practice;

import java.util.Arrays;

public class SplitLinkedList {
	
	public static ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        ListNode temp = root;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        
        int remainder = size%k;
        int[] bins = new int[k];        
            
        Arrays.fill(bins,size/k);        
        if(remainder>0){
            for(int i=0;i<remainder;i++){
                bins[i]++;
            }
        }
        
        temp = root;
        ListNode[] res = new ListNode[k];
        temp=root;
        ListNode prev=null;
        for(int i=0;i<bins.length;i++){   
        	if(bins[i]>0) {
        		res[i] = temp;
                for(int j=0;j<bins[i];j++){
                    prev = temp;
                    temp = temp.next;
                }  
                prev.next=null;
        	}            
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root = new ListNode(1);
		int[] arr = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int i=0;
		ListNode temp =root;
		while(i<arr.length) {
			temp.next=new ListNode(arr[i++]);
			temp=temp.next;
		}
		splitListToParts(root,3);
	}

}
