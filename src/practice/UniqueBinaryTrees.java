package practice;

import java.util.Arrays;

public class UniqueBinaryTrees {
	static int[] dp;

	private static int calcNumTrees(int root, int n){
		if(dp[n] != -1) {
			return dp[n];
		}

		int leftTreeSize = root-1;
		int rightTreeSize = n-root;

		int leftResult = 1;
		if (leftTreeSize>0) {
			if(dp[leftTreeSize] != -1) {
				leftResult = dp[leftTreeSize];
			} else {
				leftResult = recNumTrees(leftTreeSize);
			}
		}

		int rightResult = 1;
		if (rightTreeSize>0) {
			if(dp[rightTreeSize] != -1) {
				rightResult = dp[rightTreeSize];
			} else {
				rightResult = recNumTrees(rightTreeSize);
			}
		}
		return leftResult*rightResult;
	}

	public static int recNumTrees(int n) {
		if(dp[n] != -1) {
			return dp[n];
		}

		int result = 0;
		for(int i=1;i<=n;i++) {
			result+= calcNumTrees(i, n);
		}
		dp[n] = result;
		return result;
	}
	public static int numTrees(int n) {
		dp = new int[n+1];

		Arrays.fill(dp,-1);
		if (n == 0) {
			return 0;
		}
		if (n == 1){
			return 1;
		}

		dp[0]=0;
		dp[1]=1;

		return recNumTrees(n);
	}

	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
}
