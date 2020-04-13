package common;

import java.util.LinkedList;
import java.util.Queue;

public class ReadTreeInput {

	public static TreeNode readArray(Integer[] nodeArray) {
		if (nodeArray == null || nodeArray.length == 0) {
			return null;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(nodeArray[0]);
		queue.add(root);
		for (int i=1; i<nodeArray.length;) {
			TreeNode currentNode = queue.poll();
			if (currentNode != null) {
				if (nodeArray[i] != null) {
					currentNode.left = new TreeNode(nodeArray[i++]);
					queue.add(currentNode.left);
				} else {
					i++;
				}
				if (i < nodeArray.length) {
					if (nodeArray[i] != null) {
						currentNode.right = new TreeNode(nodeArray[i++]);
						queue.add(currentNode.right);
					} else {
						i++;
					}
				}
			}
		}

		return root;
	}
}
