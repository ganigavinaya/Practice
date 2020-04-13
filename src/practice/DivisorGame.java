package practice;

public class DivisorGame {
	private static Integer getHighestDivisor(int N) {
		if (N != 1) {
			int divisor = N / 2;
			while (divisor > 0) {
				if (N % divisor != 0) {
					divisor--;
				} else {
					return divisor;
				}
			}
		}
		return null;
	}

	public static boolean divisorGame(int N) {
		int turns = 0;
		while (true) {
			Integer divisor = getHighestDivisor(N);
			if (divisor == null) {
				break;
			}
			N -= divisor;
			turns++;
		}

		return turns % 2 == 1;
	}

	public static void main(String[] args) {
		System.out.println(divisorGame(4));
	}
}
