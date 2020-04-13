package practice;

import common.TreeNode;

public class ConsecutivePath {
	
    int max = 0;
    
    private int _longestCons(TreeNode root, Boolean inc){
        if(root.left==null && root.right==null){
        		if(max<1)
        			max = 1;
            return 1;
        }
        
        int left = 0;
        int right = 0;
        
        Boolean leftInc = null;
        Boolean rightInc = null;
        
        if(root.left!=null){
        		leftInc = root.left.val>root.val;
        		left = _longestCons(root.left,leftInc);
        		
        		if(Math.abs(root.left.val-root.val)!=1) {
        			if(max<left)
        				max = left;
        			left = 0;
        			leftInc = null;
        		}
        }
        
        if(root.right!=null){
        		rightInc = root.right.val>root.val;
        		right= _longestCons(root.right,rightInc);
        		
        		if(Math.abs(root.right.val-root.val)!=1) {        			        		
        			if(max<right)
        				max = right;
        			right = 0;
        			rightInc = null;
        		}
        }
        
        int total = 0;
        if(inc==null) {
	    		if(leftInc!=null && rightInc!=null && !leftInc==rightInc) {
	    			 total = left+right+1;      			
	    		}
	    		else
	    			total = Math.max(left, right)+1;
	    		if(max<total)
	    			max = total;
	    		return total;
        }
        
    		total = Math.max(left, right)+1;
    		if(max<total)
    			max = total;
		return total;
        		
    }
   
    
    public int longestConsecutive(TreeNode root) {
        if(root==null)
            return 0;
        
        _longestCons(root,null);
        return max;  
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		ConsecutivePath cp = new ConsecutivePath();
		System.out.println(cp.longestConsecutive(root));
		
	}

}
