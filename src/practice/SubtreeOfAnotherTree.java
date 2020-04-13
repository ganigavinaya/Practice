package practice;

import common.TreeNode;

public class SubtreeOfAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t,boolean parentMatched) {
		if(s==null & t==null){
			return true;
		}
		else if(s!=null && t!=null){
			boolean left=false,right=false;
			if(s.val==t.val){
				left = isSubtree(s.left,t.left,true);

				if(left){
					right = isSubtree(s.right,t.right,true);
					if(right)
						return true;
				}
			}
			if(!parentMatched) {
				left = isSubtree(s.left, t, false);
				if (!left) {
					return isSubtree(s.right, t, false);
				} else
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SubtreeOfAnotherTree sa = new SubtreeOfAnotherTree();
		TreeNode s = new TreeNode(1);
		s.left = new TreeNode(1);
//		s.left.left = new TreeNode(1);

//		s.right = new TreeNode(5);
//		s.right.left = new TreeNode(2);

		TreeNode t = new TreeNode(1);
//		t.left = new TreeNode(1);


		System.out.println(sa.isSubtree(s,t,false));
	}
}
