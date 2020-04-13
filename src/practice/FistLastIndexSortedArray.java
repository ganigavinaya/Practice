package practice;

import java.util.Arrays;

public class FistLastIndexSortedArray {
	public int[] searchRange(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1, true, true);
	}

	private int[] binarySearch(int[] nums,
							   int target,
							   int start,
							   int end,
							   boolean findStart,
							   boolean findEnd
	) {

		int[] result = new int[]{-1, -1};
		if (nums.length == 0 ||
				start < 0 ||
				end >= nums.length ||
				nums[start] > target ||
				nums[end] < target ||
				(start == end && nums[start] != target)) {
			return result;
		}

		if (nums[start] == target && nums[end] == target) {
			return new int[]{start, end};
		}

		int mid = (start + end) / 2;
		if (nums[start] == target) {
			if (findStart) {
				result[0] = start;
			}
			if (findEnd) {
				if (nums[mid] > target) {
					int[] left = binarySearch(nums, target, start, mid, false, true);
					result[1] = left[1];
				} else {
					int[] right = binarySearch(nums, target, mid + 1, end, false, true);
					if (right[1] == -1 && nums[mid] == target) {
						result[1] = mid;
					} else {
						result[1] = right[1];
					}

				}
			}
		} else {
			//start < target
			if (nums[end] == target) {
				findEnd = false;
			}
			if (nums[mid] == target) {
				int[] left = binarySearch(nums, target, start, mid, true, false);
				result[0] = left[0];
				if (findEnd) {
					int[] right = binarySearch(nums, target, mid + 1, end, false, true);
					if (right[1] == -1) {
						result[1] = mid;
					} else {
						result[1] = right[1];
					}
				} else {
					result[1] = end;
				}
			} else if (nums[mid] > target) {
				int[] left = binarySearch(nums, target, start, mid, true, true);
				result = left;
			} else {
				int[] right = binarySearch(nums, target, mid + 1, end, true, findEnd);
				result = right;
				if (!findEnd) {
					result[1] = end;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		FistLastIndexSortedArray solution = new FistLastIndexSortedArray();
		System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 8)));
	}
}
