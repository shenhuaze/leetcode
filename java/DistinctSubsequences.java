package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2020-01-30
 */
public class DistinctSubsequences {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] += dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(new DistinctSubsequences().numDistinct(s, t));
    }
}
