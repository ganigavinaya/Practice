package practice;

import java.util.HashMap;

public class IntToRoman {

	public static void intToRoman(int num) {
        HashMap<Integer,String> map = new HashMap<>();
        
        map.put(1,"I");
        map.put(2,"II");
        map.put(3,"III");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
        
        int remainder = num%10;
        String s = "";
        
        if(remainder>0){
	        	if(remainder<= 5 || remainder==9) {
	        		s = map.get(remainder);
	        }
	        	else {
	        		s = map.get(5)+map.get(remainder-5);
	        	}
        }
        num-=remainder;
        remainder = num%100;
        
        if(remainder>0) {
	        	if(remainder< 40) {
		    		int times = remainder/10;		    		
		    		for(int i=0;i<times;i++) {
		    			s = "X"+s;
		    		}
		    }
		    else if(remainder==40 || remainder==50 || remainder==90){
		    		s = map.get(remainder)+s;
		    }
		    else {
			    	int times = (remainder-50)/10;			   
		    		for(int i=0;i<times;i++) {
		    			s = "X"+s;
		    		}
		    		s = "L"+s;
		    }
        }
        num-=remainder;
        remainder = num%1000;
        
        if(remainder>0) {
	        	if(remainder< 400) {
		    		int times = remainder/100;
		    		for(int i=0;i<times;i++) {
		    			s = "C"+s;
		    		}
		    }
		    else if(remainder==400 || remainder==500 || remainder==900){
		    		s= map.get(remainder)+s;
		    }
		    else {
			    	int times = (remainder-500)/100;		    
		    		for(int i=0;i<times;i++) {
		    			s = "C"+s;
		    		}
		    		s = "D"+s;
		    }
	    }
        
        num-=remainder;
        remainder = num%10000;
        
        if(remainder>0) {
	    		int times = remainder/1000;
	    		for(int i=0;i<times;i++) {
	    			s ="M"+s;
	    		}
		    
	    }
        
        System.out.println(s);
    }
	
	public static void main(String[] args) {
		intToRoman(3999);

	}

}
