package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-09
 *
 * 其他解法：Robin-Karp, KMP
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (needle.charAt(0) != haystack.charAt(i)) {
                continue;
            }
            int j = 0;
            while (j < needle.length()) {
                if (i + j >= haystack.length()) {
                    break;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
                j += 1;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(new ImplementStrStr().strStr(haystack, needle));
    }
}
