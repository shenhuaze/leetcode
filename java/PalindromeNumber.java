package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-06-19
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int dividedNumber = 1;
        while (x / dividedNumber >= 10) {
            dividedNumber *= 10;
        }
        while (x > 0) {
            int left = x / dividedNumber;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % dividedNumber) / 10;
            dividedNumber /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        //int x = 121;
        int x = 1001;
        System.out.println(new PalindromeNumber().isPalindrome(x));
    }
}
