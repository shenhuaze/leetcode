package com.huaze.shen;

import java.util.Stack;

/**
 * @author Huaze Shen
 * @date 2019-07-12
 */
public class LongestValidParentheses {
    /**
     * Solution 1
     * Brute force method, using stack, T(n) = O(n^3), S(n) = O(n)
     * Time Limit Exceeded (TLE)
     */
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    /**
     * Solution 2
     * Using stack, T(n) = O(n), S(n) = O(n)
     */
    public int longestValidParentheses2(String s) {
        int maxLen = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.empty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        maxLen = Math.max(maxLen, i - start + 1);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }
        return maxLen;
    }

    /**
     * Solution 3
     * Dynamic programming, T(n) = O(n), S(n) = O(n)
     */
    public int longestValidParentheses3(String s) {
        int maxLen = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    if (i - dp[i - 1] >= 2) {
                        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    /**
     * Solution 4
     * Using stack, T(n) = O(n), S(n) = O(1)
     */
    public int longestValidParentheses4(String s) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left += 1;
            } else {
                right += 1;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, left * 2);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left += 1;
            } else {
                right += 1;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, left * 2);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        //String s = ")()())";
        String s = "(()";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
        System.out.println(new LongestValidParentheses().longestValidParentheses2(s));
        System.out.println(new LongestValidParentheses().longestValidParentheses3(s));
        System.out.println(new LongestValidParentheses().longestValidParentheses4(s));
    }
}
