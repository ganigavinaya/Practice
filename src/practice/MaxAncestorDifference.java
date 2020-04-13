package practice;

import common.ReadTreeInput;
import common.TreeNode;

public class MaxAncestorDifference {
	public class DiffTreeNode {
		TreeNode node;
		int leftDiff;
		int rightDiff;
		DiffTreeNode(TreeNode node) {
			this.node = node;
			leftDiff = 0;
			rightDiff = 0;
		}
	}

	public DiffTreeNode maxDiff(TreeNode root){
		if (root == null) {
			return new DiffTreeNode(null);
		}

		DiffTreeNode diffRoot = new DiffTreeNode(root);

		if (root.left != null) {
			DiffTreeNode left = maxDiff(root.left);
			diffRoot.leftDiff = root.val - (left.node.val - left.leftDiff);
		}
		if (root.right != null) {
			DiffTreeNode right = maxDiff(root.right);
			diffRoot.rightDiff = (right.node.val + right.rightDiff) - root.val;
		}
		return diffRoot;
	}

	public int maxAncestorDiff(TreeNode root) {
		DiffTreeNode result = maxDiff(root);
		return Math.max(result.leftDiff, result.rightDiff);
	}

	public static void main(String[] args) {
		MaxAncestorDifference maxAncestorDifference = new MaxAncestorDifference();
		maxAncestorDifference.maxAncestorDiff(ReadTreeInput.readArray(new Integer[] {8,3,10,1,6,null,14,null,null,4,7,13}));
	}
}
