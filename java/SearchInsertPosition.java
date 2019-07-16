package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-16
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (target > nums[mid]) {
                start = mid;
            } else if (target < nums[mid]) {
                end = mid;
            } else {
                return mid;
            }
        }
        if (target <= nums[start]) {
            return start;
        } else if (target <= nums[end]) {
            return end;
        } else {
            return end + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(new SearchInsertPosition().searchInsert(nums, target));
    }
}
