package JavaPractice;

public class StringReverse {

	public static void main(String[] args) {
		String s = "ABCDEFGHI";

		char[] c_arr = s.toCharArray();

//		StringBuilder sb = new StringBuilder(s);
//
//		for(int i=0,j=sb.length()-1;j>=i;j--,i++){
//			char temp = sb.charAt(i);
//			sb.setCharAt(i,sb.charAt(j));
//			sb.setCharAt(j,temp);
//		}

		for(int i=0,j=c_arr.length-1;j>=i;j--,i++){
			char temp = c_arr[i];
			c_arr[i] = c_arr[j];
			c_arr[j]=temp;
		}

		StringBuilder sb = new StringBuilder();

		for(char c:c_arr){
			sb.append(c);
		}

		System.out.println(sb.toString());

	}
}
