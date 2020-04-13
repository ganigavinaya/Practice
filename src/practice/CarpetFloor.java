package practice;

import java.util.ArrayList;

public class CarpetFloor { 
	    public static int[] answer(int area) {
	        ArrayList<Integer> arr = new ArrayList<>();
	        
	        int cube = 1;
	        int num = 1;
	        
	        while(cube<=area){
	            arr.add(cube);
	            num++;
	            cube = num*num;
	        }
	        ArrayList<Integer> res = new ArrayList<>();
	        
	        for(int i=arr.size()-1;i>=0;i--){
	            while(area>0 && area>=arr.get(i)){
	                res.add(arr.get(i));
	                area-=arr.get(i);
	            }
	        }

	        int[] resArr = new int[res.size()];
	        int i=0;
	        for(Integer x: res){
	            resArr[i++]=x;
	        }
	        
	        return resArr;
	    }
	
	public static void main(String[] args) {
		answer(1);
	}

}
