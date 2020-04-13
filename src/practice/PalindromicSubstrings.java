package practice;

public class PalindromicSubstrings {

	static int getCount(char[] newInput, int i, int j){
		int count = 0;
		while(i>=0 && j<newInput.length && newInput[i]==newInput[j]){
			i--;
			j++;
			count++;
		}

		return count;
	}

	public static int countSubstrings(String s) {
        int length = s.length();
        if(length==1 || length==0)
            return length;
        
        char[] newInput = s.toCharArray();

        int result = 0;
        for(int i=0;i<newInput.length;i++){
            result+=getCount(newInput,i,i);
			result+=getCount(newInput,i,i+1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSubstrings("hellolle"));
	}

}
