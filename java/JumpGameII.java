package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-24
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int level = 0;
        int i = 0;
        int currentMax = 0;
        while (i <= currentMax) {
            int furthest = currentMax;
            for (int j = i; j <= currentMax; j++) {
                furthest = Math.max(furthest, nums[j] + j);
                if (furthest >= nums.length - 1) {
                    return level + 1;
                }
            }
            i = currentMax + 1;
            currentMax = furthest;
            level += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new JumpGameII().jump(nums));
    }
}
