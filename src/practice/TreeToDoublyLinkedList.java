package practice;

import common.ReadTreeInput;
import common.TreeNode;

public class TreeToDoublyLinkedList {

	TreeNode head;
	TreeNode tail;

	private void treeToDList(TreeNode root) {
		if (root.left == null && root.right == null) {
			head = root;
			tail = root;
			return;
		}
		TreeNode localHead = root;
		TreeNode localTail = root;
		if(root.left != null) {
			treeToDList(root.left);
			localHead = head;
			localHead.left = root;
			root.left = tail;
			tail.right = root;
		}

		if(root.right != null) {
			treeToDList(root.right);
			localTail = tail;
			root.right = head;
			head.left = root;
		}
		localTail.right = localHead;
		localHead.left = localTail;
		head = localHead;
		tail = localTail;
	}

	public TreeNode treeToDoublyList(TreeNode root) {
		if (root == null) {
			return null;
		}
		treeToDList(root);
		return head;
	}

	public static void main(String[] args) {
		TreeNode root = ReadTreeInput.readArray(new Integer[] {4,2,5,1,3});
		TreeToDoublyLinkedList x = new TreeToDoublyLinkedList();
		x.treeToDoublyList(root);
	}
}
