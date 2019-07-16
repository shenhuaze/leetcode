package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-15
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            int startValue = nums[start];
            if (nums[mid] >= startValue) {
                if (target >= nums[mid]) {
                    start = mid;
                } else if (target >= startValue) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target <= nums[mid]) {
                    end = mid;
                } else if (target < startValue) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (target == nums[start]) {
            return start;
        }
        if (target == nums[end]) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 7;
        System.out.println(new SearchInRotatedSortedArray().search(nums, target));
    }
}
