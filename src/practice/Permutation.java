package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutation {

	public static List<List<Integer>> findPermutations(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<List<Integer>> permutations = new LinkedList<>();
		permutations.add(new ArrayList<>());

		for(int num : nums) {
			int n = permutations.size();
			for(int j=0;j<n;j++){
				List<Integer> currentPermutation = permutations.poll();
				for(int i = 0;i<=currentPermutation.size();i++) {
					List<Integer> newPermutation = new ArrayList<>(currentPermutation);
					newPermutation.add(i, num);
					if(newPermutation.size() == nums.length) {
						result.add(newPermutation);
					} else {
						permutations.add(newPermutation);
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = findPermutations(new int[] {1,5,3});

		for(List<Integer> x: result) {
			System.out.println(x);
		}
	}
}
