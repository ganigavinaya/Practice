package practice;

import common.ReadTreeInput;
import common.TreeNode;

public class PathSumIII {
	public static int pathSum(TreeNode root, int sum) {
		if(root==null) {
			return 0;
		}
		int count = traverseTreePath(root,root.val,sum);
		count += pathSum(root.left,sum);
		count+= pathSum(root.right,sum);
		return count;
	}

	public static int traverseTreePath(TreeNode root, int localSum, int totalSum) {
		int count = 0;
		if(root==null){
			return 0;
		}
		if(localSum==totalSum){
			count++;
		}
		if(root.left!=null){
			count += traverseTreePath(root.left,localSum+root.left.val,totalSum);
		}
		if(root.right!=null){
			count += traverseTreePath(root.right,localSum+root.right.val,totalSum);
		}
		return count;
	}

	public static void main(String[] args) {
		TreeNode root = ReadTreeInput.readArray(new Integer[] {1,null,2,null,3,null,4,null,5});
		System.out.println(pathSum(root, 3));
	}
}