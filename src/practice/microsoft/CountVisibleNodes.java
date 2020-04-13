package practice.microsoft;

import common.ReadTreeInput;
import common.TreeNode;

public class CountVisibleNodes {

	private int countVisibleNodes(TreeNode root, int maxValue){
		int result = 0;
		if (root == null) {
			return result;
		}

		if (root.val > maxValue){
			result++;
			maxValue = root.val;
		}
		result += countVisibleNodes(root.left, maxValue);
		result += countVisibleNodes(root.right, maxValue);
		return result;
	}
	public int countVisibleNodes(TreeNode root) {
		return countVisibleNodes(root, Integer.MIN_VALUE);
	}

	public static void main(String[] args) {
		CountVisibleNodes countVisibleNodes = new CountVisibleNodes();
		TreeNode root = ReadTreeInput.readArray(new Integer[]{-10,null,-15,null,-1});
		countVisibleNodes.countVisibleNodes(root);
	}
}
