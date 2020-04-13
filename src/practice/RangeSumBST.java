package practice;

import common.ReadTreeInput;
import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumBST {
	public int rangeSumBST(TreeNode root, int L, int R) {
		Queue<TreeNode> queue = new LinkedList<>();
		int sum = 0;
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			if (current == null) {
				continue;
			}
			if (current.val >= L && current.val <= R) {
				sum += current.val;
			}
			if (current.val>= R) {
				queue.add(current.left);
			} else if (current.val<=L) {
				queue.add(current.right);
			} else {
				queue.add(current.left);
				queue.add(current.right);
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		TreeNode root = ReadTreeInput.readArray(new Integer[]{10,5,15,3,7,13,18,1,null,6});

		RangeSumBST rangeSumBST = new RangeSumBST();
		System.out.println(rangeSumBST.rangeSumBST(root, 6, 10));

	}
}
