package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-19
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            while (nums[i] > 0 && nums[i] <= size && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < size; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return size + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        //int[] nums = {3, -2, 4, -1, 1};
        //int[] nums = {-1, 4, 2, 1, 9, 10};
        //int[] nums = {1, 2, 4, 5};
        //int[] nums = {1, 2, 3, 4};
        //int[] nums = {3, 4, 2};
        int[] nums = {0, 3, 0};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }
}
