package practice;

public class MergeKLists {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode result = null;
		ListNode currentResult = null;
		while (true) {
			ListNode minimum = null;
			int lastMinIndex = 0;
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] != null) {
					if (minimum == null || minimum.val > lists[i].val) {
						minimum = new ListNode(lists[i].val);
						lastMinIndex = i;
					}
				}
			}
			if (minimum == null) {
				break;
			} else {
				if (result == null) {
					result = minimum;
					currentResult = result;
				} else {
					currentResult.next = minimum;
					currentResult = currentResult.next;
				}
				lists[lastMinIndex] = lists[lastMinIndex].next;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		lists[0] = readList(new int[]{1,4,5});
		lists[1] = readList(new int[]{1,3,4});
		lists[2] = readList(new int[]{2,6});

		ListNode result = mergeKLists(lists);

	}

	private static ListNode readList(int[] input) {
		ListNode head = new ListNode(input[0]);
		ListNode current = head;

		for(int i=1;i<input.length;i++){
			current.next = new ListNode(input[i]);
			current = current.next;
		}
		return head;
	}
}
