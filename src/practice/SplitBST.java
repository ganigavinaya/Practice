package practice;

import common.TreeNode;

public class SplitBST {
	
	public TreeNode[] splitBST(TreeNode root, int V) {
		TreeNode[] res = new TreeNode[2];
		
		if(root==null) {
			res[0]=null;
			res[1]=null;
			return res;
		}		
		
		if(root.val>V) { //V might be in left
			res = splitBST(root.left,V);
			root.left=res[1];										
			res[1]=root;
		}
		else { //V might be in right			
			res = splitBST(root.right,V);
			root.right=res[0];	
			res[0]=root;
		}           
        return res;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(688);
//		root.left = new TreeNode(3);
		root.right = new TreeNode(693);
//		root.left.left = new TreeNode(1);
//		root.left.right = new TreeNode(4);
//		root.left.right.right = new TreeNode(5);
//		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(711);
		root.right.right.right = new TreeNode(751);
		root.right.right.right.right = new TreeNode(757);
		
		SplitBST obj = new SplitBST();
		TreeNode[] res = obj.splitBST(root, 714);
		System.out.println(res[0].val+" "+res[1].val);
	}

}
