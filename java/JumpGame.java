package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-08-03
 */
public class JumpGame {
    /**
     * Solution 1: Backtracking
     * Time Limit Exceeded
     * T(n) = O(2^n), S(n) = O(n)
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return canJumpFromPosition(0, nums);
    }

    private boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        //for (int i = position + 1; i <= furthestJump; i++) {
        for (int i = furthestJump; i > position; i--) {
            if (canJumpFromPosition(i, nums)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Solution 2: Dynamic Programming Top-down
     * T(n) = O(n^2), S(n) = O(n)
     */
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[nums.length - 1] = Index.GOOD;
        return canJumpFromPosition2(0, nums, memo);
    }

    enum Index{
        GOOD,
        BAD,
        UNKNOWN
    }

    private boolean canJumpFromPosition2(int position, int[] nums, Index[] memo) {
        if (memo[position] == Index.GOOD) {
            return true;
        }
        if (memo[position] == Index.BAD) {
            return false;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int i = position + 1; i <= furthestJump; i++) {
            if (canJumpFromPosition2(i, nums, memo)) {
                memo[i] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }

    /**
     * Solution 3: Dynamic Programming Bottom-up
     * T(n) = O(n^2), S(n) = O(n)
     */
    public boolean canJump3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[nums.length - 1] = Index.GOOD;
        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }

    /**
     * Solution 4: Greedy
     */
    public boolean canJump4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int leftMostGoodIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= leftMostGoodIndex) {
                leftMostGoodIndex = i;
            }
        }
        return leftMostGoodIndex == 0;
    }

    public static void main(String[] args) {
        //int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(new JumpGame().canJump(nums));
        System.out.println(new JumpGame().canJump2(nums));
        System.out.println(new JumpGame().canJump3(nums));
        System.out.println(new JumpGame().canJump4(nums));
    }
}
