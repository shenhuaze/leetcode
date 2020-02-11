package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2020-02-11
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!isAlphabet(s.charAt(left))) {
                left += 1;
            } else if (!isAlphabet(s.charAt(right))) {
                right -= 1;
            } else if (lower(s.charAt(left)) == lower(s.charAt(right))) {
                left += 1;
                right -= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphabet(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        return false;
    }

    private char lower(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return String.valueOf(ch).toLowerCase().charAt(0);
        }
        return ch;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
