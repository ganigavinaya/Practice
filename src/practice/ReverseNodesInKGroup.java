package practice;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode groupEnd = null;
		ListNode nextGroupEnd = null;
		ListNode curr = head;
		ListNode prev = null;

		ListNode tempHead = null;
		ListNode tempCurr = null;

		int i=0;
		while(curr!=null){
			if(i<k){
				ListNode next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				i++;
			}
			if(i==k) {
				i=0;
				if (groupEnd == null) {
					groupEnd = head;
					head = prev;
				}
				else {
					groupEnd.next = prev;
					groupEnd = nextGroupEnd;
				}
				nextGroupEnd = curr;
				tempHead = null;
			}
			else{
				if(tempHead==null) {
					tempHead = new ListNode(prev.val);
					tempCurr = tempHead;
				}
				else{
					tempCurr.next = new ListNode(prev.val);
					tempCurr = tempCurr.next;
				}
			}
		}

		if(groupEnd!=null)
			groupEnd.next = tempHead;
		else if(i<k)
			head = tempHead;

		return head;
	}

	public static void main(String[] args) {
		int[] array = new int[]{1,2};
		int k=3;

		ListNode head = new ListNode(array[0]);
		ListNode temp = head;
		for(int i=1;i<array.length;i++){
			temp.next = new ListNode(array[i]);
			temp = temp.next;
		}

		ReverseNodesInKGroup rk = new ReverseNodesInKGroup();
		head = rk.reverseKGroup(head,k);

		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}

	}
}
