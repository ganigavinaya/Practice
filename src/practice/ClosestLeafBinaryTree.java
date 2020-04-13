package practice;

import common.TreeNode;

import java.util.Stack;

public class ClosestLeafBinaryTree {
	
	TreeNode leaf = null;
	
	TreeNode findK(TreeNode root, int k, Stack<TreeNode> path) {
		path.push(root);
		if(root==null)
			return null;

		if(root.val==k) {			
			return root;
		}
		TreeNode left = findK(root.left,k,path);
		if(left!=null)
			return left;
		else
			path.pop();
		
		TreeNode right = findK(root.right,k,path);
		if(right==null)			
			path.pop();	
		return right;
	}
	
	int findLeaf(TreeNode root){
		if(root==null)
			return Integer.MAX_VALUE;
		else if(root.left==null && root.right==null) {
			leaf = root;
			return 0;
		}
		else {			
			int l = findLeaf(root.left);
			TreeNode left = leaf;
			int r = findLeaf(root.right);			
			if(l<=r) {
				leaf = left;
				return l+1;
			}
			else {
				return r+1;
			}
		}
		
	}
	
	public int findClosestLeaf(TreeNode root, int k) {
		Stack<TreeNode> path = new Stack<>();
		findK(root,k,path);
		
		int min = findLeaf(path.pop());
		TreeNode minL = leaf;
		int dist = 0;
		while(path.size()>0) {	
			dist++;
			int curr = dist+findLeaf(path.pop());
			if(curr<min) {
				minL = leaf;
				min = curr;
			}
		}
		
		return minL.val;		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);	
		
		root.right.left.left = new TreeNode(6);
		root.right.left.left.left = new TreeNode(8);
		root.right.left.left.right = new TreeNode(9);
		
		root.right.right.right = new TreeNode(7);
		root.right.right.right.left = new TreeNode(10);
		
		
		ClosestLeafBinaryTree cb = new ClosestLeafBinaryTree();
		System.out.println(cb.findClosestLeaf(root, 3));
	}

}
