package practice;

public class DecodeString {

	int decodeStringRec(char[] arr, StringBuilder sb, int start){
        

        int i=start;

        while(i<arr.length) {
        		StringBuilder limitStr = new StringBuilder();
	        while(arr[i]!='[' && arr[i]>='0' && arr[i]<='9'){
	            limitStr.append(arr[i++]);
	        }
	        if(limitStr.length()==0) {
		        	while(i<arr.length && ((arr[i]>='a' && arr[i]<='z') || (arr[i]>='A' && arr[i]<='Z'))){
	                sb.append(arr[i++]);
	            }
		        	if(i>=arr.length || arr[i]==']')
		        		break;
		        	else if(arr[i]>='0' && arr[i]<='9')
		        		continue;
	        }	        		
	        int limit = Integer.parseInt(limitStr.toString());
	        i++;
	        
	        StringBuilder sub = new StringBuilder();
	        while(arr[i]!=']'){
	            while((arr[i]>='a' && arr[i]<='z') || (arr[i]>='A' && arr[i]<='Z')){
	                sub.append(arr[i++]);
	            }
	            if(arr[i]>='0' && arr[i]<='9'){
	                i = decodeStringRec(arr,sub,i); 
	            }
	        }
	        for(int j=0;j<limit;j++){
	            sb.append(sub);
	        }
	        
	        i++;
	        if(i<arr.length && arr[i]==']') {
	        		break;
	        }
        }
        return i;
    }
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        decodeStringRec(s.toCharArray(),sb,0);

        return sb.toString();
    }
	
	public static void main(String[] args) {
		DecodeString ds = new DecodeString();
		System.out.println(ds.decodeString("3[a]2[b4[F]c]"));
//		System.out.println(ds.decodeString("2[abc]3[cd]ef"));
	}

}
