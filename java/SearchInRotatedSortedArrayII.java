package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-10-05
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            int startValue = nums[start];
            //if (nums[mid] == target) {
            //    return true;
            //}
            if (nums[mid] > startValue) {
                if (target >= nums[mid]) {
                    start = mid;
                } else if (target >= startValue) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < startValue) {
                if (target <= nums[mid]) {
                    end = mid;
                } else if (target < startValue) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                start += 1;
            }
        }
        return  (target == nums[start] || target == nums[end]);
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));
    }
}
