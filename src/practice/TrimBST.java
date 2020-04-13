package practice;

import common.ReadTreeInput;
import common.TreeNode;

public class TrimBST {
	private TreeNode trimTree(TreeNode root, int L, int R) {
		if (root == null){
			return null;
		}
		if (root.val>R){
			root = trimTree(root.left, L, R);
		} else if (root.val<L) {
			root = trimTree(root.right, L, R);
		} else {
			root.left = trimTree(root.left, L, R);
			root.right = trimTree(root.right, L, R);
		}

		return root;
	}

	public TreeNode trimBST(TreeNode root, int L, int R) {
		return trimTree(root, L, R);
	}

	public static void main(String[] args) {
		TreeNode root = ReadTreeInput.readArray(new Integer[] {3,0,4,null,2,null,null,1});
		TrimBST trimBST = new TrimBST();
		TreeNode newRoot = trimBST.trimBST(root, 1, 3);
	}
}
