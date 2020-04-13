package practice;

import java.util.Arrays;

public class LessThanEqual {

	class Node{
		int val;
		Node left,right;
		int leftCount = 1;

		Node(int val){
			this.val = val;
		}
	}

	int[] lessThanEqualTo(int[] arr1, int[] arr2){
		Node r1 = new Node(arr1[0]);

		for(int i=1;i<arr1.length;i++){
			Node temp = r1;

			while(true){
				if(arr1[i]>temp.val){
					if(temp.right==null){
						temp.right = new Node(arr1[i]);
						break;
					}
					else{
						temp = temp.right;
					}
				}
				else{
					if(temp.left==null){
						temp.leftCount++;
						temp.left = new Node(arr1[i]);
						break;
					}
					else{
						temp.leftCount++;
						temp = temp.left;
					}
				}
			}
		}

		int[] result = new int[arr2.length];
		for(int i=0;i<arr2.length;i++){
			int total = 0;
			Node temp = r1;

			while(temp!=null){
				if(temp.val<=arr2[i]){
					total+=temp.leftCount;
					temp = temp.right;
				}
				else{
					temp = temp.left;
				}
			}
			result[i]=total;
		}

		return result;
	}

	public static void main(String[] args) {
		LessThanEqual le = new LessThanEqual();

		System.out.println(Arrays.toString(le.lessThanEqualTo(new int[]{2,10,5,4,8},new int[]{3,1,7,8})));
	}
}
