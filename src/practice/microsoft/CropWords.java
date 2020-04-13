package practice.microsoft;

public class CropWords {
	public static String cropWords(String s, int k){
		if (s.length()<=k) {
			return s;
		}

		StringBuilder sb = new StringBuilder(s);

		if(sb.charAt(k) != ' '){
			while(k>=0 && sb.charAt(k) != ' '){
				k--;
			}
			if (k<0){
				return "";
			}
		}

		if (sb.charAt(k) == ' ') {
			k--;
			while(k>=0 && sb.charAt(k)==' '){
				k--;
			}
			return sb.substring(0,k+1);
		}
		return "";
	}

	public static void main(String[] args) {
		System.out.println("!" +cropWords("codility we test coders", 14) +"!");
	}
}
