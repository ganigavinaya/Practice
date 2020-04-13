package practice;

public class PermutationOfGivenLength {

	static void permutation(char[] perm, int pos, String str) {
	    if (pos == perm.length) {
	        System.out.println(new String(perm));
	    } else {
	        for (int i = 0 ; i < str.length() ; i++) {
	            perm[pos] = str.charAt(i);
	            permutation(perm, pos+1, str);
	        }
	    }
	}
	
	public static void main(String[] args) {
		char[] perm = new char[5];
		permutation(perm, 0, "abcdefghiklimnop");
	}

}
