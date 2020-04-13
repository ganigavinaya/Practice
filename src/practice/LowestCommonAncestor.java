package practice;

import common.ReadTreeInput;
import common.TreeNode;

public class LowestCommonAncestor {
	public class TreeNodeDepth{
		TreeNode node;
		int depth;
		TreeNodeDepth(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	private TreeNodeDepth lcaRec(TreeNode root){
		TreeNodeDepth depthRoot = new TreeNodeDepth(root, 0);
		if(root == null){
			return depthRoot;
		}

		TreeNodeDepth left = lcaRec(root.left);
		TreeNodeDepth right = lcaRec(root.right);

		if (left.depth == right.depth) {
			return new TreeNodeDepth(root, left.depth+1);
		} else if(left.depth > right.depth){
			return new TreeNodeDepth(left.node, left.depth+1);
		} else {
			return new TreeNodeDepth(right.node, right.depth+1);
		}
	}
	public TreeNode lcaDeepestLeaves(TreeNode root) {
		return lcaRec(root).node;
	}

	public static void main(String[] args) {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		TreeNode root = ReadTreeInput.readArray(new Integer[] {1,2,3,4});
		lca.lcaDeepestLeaves(root);
	}
}
