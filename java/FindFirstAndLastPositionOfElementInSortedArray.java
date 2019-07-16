package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-16
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int firstPosition = findFirstPosition(nums, target);
        int lastPosition = findLastPosition(nums, target);
        result[0] = firstPosition;
        result[1] = lastPosition;
        return result;
    }

    private int findFirstPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (target > nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    private int findLastPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (target >= nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }

    private void demo() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        new FindFirstAndLastPositionOfElementInSortedArray().demo();
    }
}
