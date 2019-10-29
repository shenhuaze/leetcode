package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-10-26
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i < length + 1; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = 0;
            }
            if (i == 1) {
                continue;
            }
            if (s.charAt(i - 2) == '1') {
                dp[i] += dp[i - 2];
            }
            if (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        //String s = "226";
        String s = "10";
        System.out.println(new DecodeWays().numDecodings(s));
    }
}
