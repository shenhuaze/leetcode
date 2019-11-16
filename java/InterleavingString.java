package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-11-06
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int n1 = s1.length();
        int n2 = s2.length();
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n1; i++) {
            if (dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            }
        }
        for (int i = 1; i <= n2; i++) {
            if (dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                }
                if (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
    }
}
