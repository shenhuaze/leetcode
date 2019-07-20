package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-20
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i : pos) {
            if (result.length() == 0 && i == 0) {
                continue;
            }
            result.append(i);
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(new MultiplyStrings().multiply(num1, num2));
    }
}
