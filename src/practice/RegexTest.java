package practice;

import java.util.regex.Pattern;

public class RegexTest {

	
	public static void main(String[] args) {
		System.out.println(Pattern.matches("(C|T|E[AGMS])(?:\\d+)","C8"));

	}

}
