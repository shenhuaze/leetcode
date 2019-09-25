package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-09-22
 */
public class SortColors {
    /**
     * Solution 1
     */
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int i = 0; i < nums.length; i++) {
            colors[nums[i]] += 1;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < colors[i]; j++) {
                nums[index] = i;
                index += 1;
            }
        }
    }

    /**
     * Solution 2
     */
    public void sortColors2(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        for (int i = 0; i <= blue; i++) {
            if (nums[i] == 0) {
                swap(nums, i, red);
                red += 1;
            } else if (nums[i] == 2) {
                swap(nums, i, blue);
                i -= 1;
                blue -=1 ;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        //int[] nums = {2, 0, 2, 1, 1, 0};
        //int[] nums = {2, 1};
        int[] nums = {2, 0, 1, 2, 0};
        new SortColors().sortColors(nums);
        //new SortColors().sortColors2(nums);
        for (int i: nums) {
            System.out.print(i + " ");
        }
    }
}
