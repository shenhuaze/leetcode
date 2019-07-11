package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-11
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i + 1] > nums[i]) {
                int j = nums.length - 1;
                while (j > i) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                    j -= 1;
                }
                swap(nums, i, j);
                reverse(nums, i + 1);
                return;
            }
            i -= 1;
        }
        reverse(nums, 0);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i) {
        int left = i;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left += 1;
            right -= 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        new NextPermutation().nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
