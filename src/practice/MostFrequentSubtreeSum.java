package practice;

import common.TreeNode;

import java.util.*;

public class MostFrequentSubtreeSum {
    
    int max = Integer.MIN_VALUE;
    HashMap<Integer,Integer> map;
    
    
    int findSum(TreeNode root){
        int left = root.left==null?0:findSum(root.left);
        int right = root.right==null?0:findSum(root.right);

        int sum = root.val+left+right;

        Integer count = map.getOrDefault(sum,0);
        map.put(sum,++count);

		max = Math.max(max,count);

        return sum;
    }
    
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null)
            return new int[0];
        
        map = new HashMap<>();

        findSum(root);
        
        ArrayList<Integer> values = new ArrayList<>();

        for(Map.Entry<Integer,Integer> e:map.entrySet()){
        	if(e.getValue()==max){
        		values.add(e.getKey());
			}
        }

        int[] res =  new int[values.size()];

        int i=0;
        for(Integer x:values){
        	res[i++]=x;
		}

        return res;
    }
    
	public static void main(String[] args) {
		MostFrequentSubtreeSum s = new MostFrequentSubtreeSum();		
		TreeNode tr = new TreeNode(5);
		tr.left = new TreeNode(2);
        tr.right = new TreeNode(-5);

        System.out.println(Arrays.toString(s.findFrequentTreeSum(tr)));


	}

}
