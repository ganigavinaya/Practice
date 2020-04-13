package practice;

public class MagicNumber {

	public int magicalString(int n) {
        if(n==1 || n==2)
            return 1;        
        
        StringBuilder str = new StringBuilder("122");
        
        char digit = '1';
        int oneCount = 1;
        for(int i=2;i<n;i++ ){
            if(str.charAt(i)=='1'){
                str.append(digit);
                oneCount++;                
            }
            else{
                str.append(digit);   
                str.append(digit);   
            }
            if(digit=='1')
                digit++;
            else
                digit--;
        }
        
        return oneCount;
    }
	
	public static void main(String[] args) {
		MagicNumber mn = new MagicNumber();
		System.out.println(mn.magicalString(5));

	}

}
