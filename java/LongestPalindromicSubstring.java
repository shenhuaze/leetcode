package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-06-16
 */
public class LongestPalindromicSubstring {
    class StartAndLength {
        int start;
        int len;
        StartAndLength(int start, int len) {
            this.start = start;
            this.len = len;
        }
    }

    /**
     * Solution 1
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int n = s.length();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < n - 1; i++) {
            StartAndLength startAndLengthOdd = searchPalindrome(s, i, i);
            StartAndLength startAndLengthEven = searchPalindrome(s, i, i + 1);
            if (startAndLengthEven.len > maxLen) {
                start = startAndLengthEven.start;
                maxLen = startAndLengthEven.len;
            }
            if (startAndLengthOdd.len > maxLen) {
                start = startAndLengthOdd.start;
                maxLen = startAndLengthOdd.len;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private StartAndLength searchPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }
        return new StartAndLength(left + 1, right - left - 1);
    }

    /**
     * Solution 2
     */
    public String longestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }
        int n = s.length();
        int start = 0;
        int maxLen = 0;
        int i = 0;
        while (i < n - 1) {
            if (n - i < maxLen / 2) {
                break;
            }
            int left = i;
            int right = i;
            while ((right < n - 1) && (s.charAt(right) == s.charAt(right + 1))) {
                right += 1;
            }
            i = right + 1;
            StartAndLength startAndLength = searchPalindrome(s, left, right);
            if (startAndLength.len > maxLen) {
                start = startAndLength.start;
                maxLen = startAndLength.len;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "dcbab";
        //String s = "a";
        //String palindrome = new LongestPalindromicSubstring().longestPalindrome(s);
        String palindrome = new LongestPalindromicSubstring().longestPalindrome2(s);
        System.out.println(palindrome);
    }
}
