package practice;

public class BinarySearch {

	static int sort(int[] ele, int target) {
		if (ele == null || ele.length <= 0)
			return -1;
		int left = 0, right = ele.length - 1;
		while (left < right) {
			int middle = (left + right + 1) / 2;
			if (ele[middle] > target) {
				right = middle - 1;
			} else if (ele[middle] == target) {
				return middle;
			} else {
				left = middle + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		int tar = 2;
		int ret = sort(a, tar);
		System.out.println(ret);
	}
}
