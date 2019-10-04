package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-10-03
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int num: nums) {
            if (index < 2 || num > nums[index - 2]) {
                nums[index] = num;
                index += 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums));
    }
}
