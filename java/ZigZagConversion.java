package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-06-17
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += 2 * numRows - 2) {
                result.append(s.charAt(j));
                int temp = j + 2 * numRows - 2 - 2 * i;
                if (i > 0 && i < numRows - 1 && temp < s.length()) {
                    result.append(s.charAt(temp));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = new ZigZagConversion().convert(s, numRows);
        System.out.println(result);
    }
}
