package com.huaze.shen;

import java.util.Arrays;

/**
 * @author Huaze Shen
 * @date 2019-08-26
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        int size = digits.length;
        for (int i = size - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[size + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        //int[] digits = {1, 2, 3};
        int[] digits = {9, 9, 9};
        int[] results = new PlusOne().plusOne(digits);
        for (int i : results) {
            System.out.print(String.valueOf(i) + ", ");
        }
    }
}
