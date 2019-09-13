package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-09-09
 */
public class ClimbingStairs {
    /**
     * Solution 1
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Solution 2
     */
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 1;
        int b = 2;
        int c;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    /**
     * Solution 3
     */
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            b += a;
            a = b - a;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(3));
        System.out.println(new ClimbingStairs().climbStairs2(3));
        System.out.println(new ClimbingStairs().climbStairs3(3));
    }
}
