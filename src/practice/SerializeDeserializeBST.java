package practice;

import common.TreeNode;

public class SerializeDeserializeBST {
	
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root==null) {
			return "-1";
		}
		
		String s = root.val+" "+serialize(root.left)+" "+serialize(root.right);
		return s;
	}

	public class Index{
		int i;
	}
	//String s;
	TreeNode deserializeRec(String s,Index in) {		
		int spaceInd = s.indexOf(' ',in.i);
		if(spaceInd<0)
			return null;
		int val = Integer.parseInt(s.substring(in.i, spaceInd));
		TreeNode root = null;
		in.i = spaceInd+1;
		if(val!=-1) {
			root = new TreeNode(val);			
			root.left = deserializeRec(s,in);
			root.right = deserializeRec(s,in);
		}
		return root;
	}
	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {		
		Index in = new Index();
		return deserializeRec(data,in);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);	
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		root.left.left.right = new TreeNode(8);
		root.left.right.left = new TreeNode(9);	
		
		root.right.right.right = new TreeNode(10);
		
		SerializeDeserializeBST sd = new SerializeDeserializeBST();
		String s = sd.serialize(root);
		TreeNode newRoot = sd.deserialize(s);
		System.out.println(newRoot.val);

	}
	
}
