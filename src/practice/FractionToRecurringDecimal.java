package practice;

import java.util.HashMap;

public class FractionToRecurringDecimal {

	public static String fractionToDecimal(long numerator, long denominator) {
        
        HashMap<Long,Integer> map = new HashMap<>();
        String sign = "";
        if(numerator<0 || denominator<0) {
        	if(!(numerator<0 && denominator<0)) {        		
	            sign = "-";	            
        	}        	
        }
        
        long d = Math.abs(denominator);
        long n = Math.abs(numerator);
        long q = n/d;
                
        long remainder = (long) ((n%d)*10);
        if(remainder==0)
        	if(q==0)
        		return ""+q;
        	else
        		return sign+q;
        
                
        String decimal = "";
        

        while(remainder>0) {
        	if(map.containsKey(remainder)){
        		int len = decimal.length()-map.get(remainder);
        		String tempDecimal = "";
        		long tempRem = remainder;
        		while(len>0) {        			
        			tempDecimal+=(tempRem/d);
        			tempRem=(tempRem%d)*10;  
        			len--;
        		}
        		int prevIndex = map.get(remainder);
        		String repeat = decimal.substring(prevIndex);
        		if(tempDecimal.equals(repeat))
        			return sign+q+"."+decimal.substring(0,prevIndex)+"("+repeat+")";
        	}  
        	else {
        		map.put(remainder, decimal.length());
        		decimal+=(remainder/d);
        		remainder=(remainder%d)*10;        		
        	}
        }
        
        return sign+q+"."+decimal;
        
    }

	public static void main(String[] args) {
		System.out.println(fractionToDecimal(-2147483648,1));
		
	}

}
