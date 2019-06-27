package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-06-27
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] value = {1000, 500, 100, 50, 10, 5, 1};
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < roman.length; i += 2) {
            int x = num / value[i];
            if (x < 4) {
                for (int j = 1; j <= x; j++) {
                    result.append(roman[i]);
                }
            } else if (x == 4) {
                result.append(roman[i]);
                result.append(roman[i - 1]);
            } else if (x < 9) {
                result.append(roman[i - 1]);
                for (int j = 6; j <= x; j++) {
                    result.append(roman[i]);
                }
            } else if (x == 9) {
                result.append(roman[i]);
                result.append(roman[i - 2]);
            }
            num %= value[i];
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int num = 1994;
        System.out.println(new IntegerToRoman().intToRoman(num));
    }
}
