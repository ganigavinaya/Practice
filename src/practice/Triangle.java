package practice;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	
//	private int minTotalRec(int parentLevel,int parentIndex, int parentTotal){
//        if(parentLevel+1<triangle.size()){
//            List<Integer> arr = triangle.get(parentLevel+1);
//            
//            int left = arr.get(parentIndex);
//    			int right = arr.get(parentIndex+1);
//    			int leftTotal = parentTotal+left;
//    			int rightTotal = parentTotal+right;
//    			
//            if(parentLevel+2==triangle.size()){
//                return Math.min(leftTotal,rightTotal);
//            }
//            else{              
//            		int leftMin = minTotalRec(parentLevel+1,parentIndex,leftTotal);
//            		int rightMin = minTotalRec(parentLevel+1,parentIndex+1,rightTotal);
//                return Math.min(leftMin,rightMin); 
//            }
//        }
//        return Integer.MAX_VALUE;
//    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0)
            return 0;
        if(triangle.size()==1)
            return triangle.get(0).get(0);
        
        List<List<Integer>> matrix = new ArrayList<>();  
        matrix.add(triangle.get(triangle.size()-1));

        for(int i=triangle.size()-2,k=0;i>=0;i--,k++) {
			List<Integer> arr = new ArrayList<>();
			for(int j=0;j<triangle.get(i).size();j++) {
				arr.add(Math.min(matrix.get(k).get(j)+triangle.get(i).get(j), matrix.get(k).get(j+1)+triangle.get(i).get(j)));
			}
			matrix.add(arr);
		}
        return matrix.get(matrix.size()-1).get(0);        
        
    }
    
	public static void main(String[] args) {
		Triangle t = new Triangle();
		
		List<List<Integer>> traingle = new ArrayList<>();
		
		List<Integer> a = new ArrayList<>();
		a.add(2);
		traingle.add(a);
		
		List<Integer> b = new ArrayList<>();
		b.add(3);
		b.add(4);
		traingle.add(b);
		
		List<Integer> c = new ArrayList<>();
		c.add(6);
		c.add(5);
		c.add(7);
		traingle.add(c);
		
		List<Integer> d = new ArrayList<>();
		d.add(4);
		d.add(1);
		d.add(8);
		d.add(3);
		traingle.add(d);
		
		System.out.println(t.minimumTotal(traingle));
	}

}
