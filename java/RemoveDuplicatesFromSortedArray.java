package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-09
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            len += 1;
            nums[len - 1] = nums[i];
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //int[] nums = {1, 1, 2};
        int len = new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ", ");
        }
    }
}
