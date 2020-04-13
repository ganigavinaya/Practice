package practice;

public class NextClosestTime {

	public String nextClosestTime(String time) {
		
		int[] digit = new int[4];
        int index=0;        
        
        for(char c:time.toCharArray()){   
            if(c!=':'){
                digit[index++]=Integer.parseInt(c+"");
            }            
        }                       
        
        int len =digit.length;
        while(true) {
	        int j=len-2;
	        int k=len-1;
	        
	        for(;j>=0;j--){
	            if(digit[j]<digit[j+1])
	                break;
	        }
	        
	        if(j>=0){
	            for(;k>=0;k--){
	                if(digit[j]<digit[k])
	                    break;
	            }
	
	            int temp=digit[j];
	            digit[j]=digit[k];
	            digit[k]=temp;
	            j++;
	        }
	        else{
	            j=0;
	        }
	        for(int i=len-1;i>=0 && i>j && j<len;i--,j++){
	            int temp=digit[j];
	            digit[j]=digit[i];
	            digit[i]=temp;
	        }
	        
	        if(!(digit[0]>2 || digit[2]>6 || (digit[0]==2 && digit[1]>3) || (digit[2]==6 && digit[3]>0))) {
	        	break;
	        }
	        
        }
        
        return ""+digit[0]+digit[1]+":"+digit[2]+digit[3];
                    
    }
	
	public static void main(String[] args) {
		NextClosestTime nc = new NextClosestTime();
		System.out.println(nc.nextClosestTime("11:00"));
	}

}
