package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-27
 */
public class MaximumSubarray {
    /**
     * Solution 1: Brute force
     * Time Limit Exceeded
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /**
     * Solution 2: Divide and Conquer
     * T(N) = O(NlogN), S(N) = O(logN)
     */
    public int maxSubArray2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int cross(int[] nums, int left, int right, int p) {
        if (left == right) {
            return nums[left];
        }
        int leftSubSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = p; i >= left; i--) {
            currSum += nums[i];
            leftSubSum = Math.max(leftSubSum, currSum);
        }
        int rightSubSum = Integer.MIN_VALUE;
        currSum = 0;
        for (int i = p + 1; i <= right; i++) {
            currSum += nums[i];
            rightSubSum = Math.max(rightSubSum, currSum);
        }
        return leftSubSum + rightSubSum;
    }

    private int helper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int p = (left + right) / 2;
        int leftSum = helper(nums, left, p);
        int rightSum = helper(nums, p + 1, right);
        int crossSum = cross(nums, left, right, p);
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //System.out.println(new MaximumSubarray().maxSubArray(nums));
        System.out.println(new MaximumSubarray().maxSubArray2(nums));
    }
}
