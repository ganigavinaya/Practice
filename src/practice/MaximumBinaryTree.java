package practice;

import common.TreeNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MaximumBinaryTree {

	HashMap<Integer,Integer> map = new HashMap<>();
	
	void placeTree(TreeNode n, TreeNode root){
		if(map.get(root.val)>map.get(n.val)) {
			if(root.left==null) {
				root.left = n;
			}
			else {
				placeTree(n,root.left);
			}
		}
		else {
			if(root.right==null) {
				root.right = n;
			}
			else {
				placeTree(n,root.right);
			}
		}
	}
	public TreeNode constructMaximumBinaryTree(int[] nums) {        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<nums.length;i++) {	
        	map.put(nums[i], i);
        	pq.add(nums[i]);
        }
        
        TreeNode root = new TreeNode(pq.poll());
        while(!pq.isEmpty()) {
        	placeTree(new TreeNode(pq.poll()), root); 	
        }
        return root;
    }

	public static void main(String[] args) {
		MaximumBinaryTree mb = new MaximumBinaryTree();
		mb.constructMaximumBinaryTree(new int[] {3,2,1,6,0,5});
	}

}
