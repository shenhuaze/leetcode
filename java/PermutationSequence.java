package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-08-13
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        String num = "123456789";
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        k -= 1;
        for (int i = 0; i < n; i++) {
            int index = k / factorial[n - i - 1];
            k %= factorial[n - i - 1];
            stringBuilder.append(num.charAt(index));
            if (index == n - 1) {
                num = num.substring(0, index);
            } else {
                num = num.substring(0, index) + num.substring(index + 1);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        System.out.println(new PermutationSequence().getPermutation(n, k));
    }
}
