package practice;

public class DecodeWays {

	public static int numDecodings(String s) {
		 
        if(s.length()==0){
            return 0;
        }
        if(s.charAt(0)=='0')
            return 0;
        if(s.length()==1)
            return 1;
        
        int[] result = new int[s.length()+1];
        
        result[0]=1;
        
        result[1]=1;
        
        for(int i=2;i<=s.length();i++){
            int num = Integer.parseInt(s.substring(i-2, i));
            if(num==0){
            		return 0;
            }
            else if(num<11){
                result[i]=result[i-2];
            }
            else if(num<27) {
            		if(s.charAt(i-1)!='0')
            			result[i]=result[i-2]+result[i-1];
            		else
            			result[i]=result[i-2];

            }
            else if(num>26 && s.charAt(i-1)!='0'){
                result[i]=result[i-1];
            }
            else{                
                return 0;
            }
            
        }
        
        return result[s.length()];
    }

	public static void main(String[] args) {
		DecodeWays.numDecodings("12120");

	}

}
