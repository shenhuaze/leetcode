package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-09-01
 */
public class AddBinary {
    /**
     * Solution 1
     */
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        if (a.length() > b.length()) {
            return helper(a, b);
        } else {
            return helper(b, a);
        }
    }

    private String helper(String a, String b) {
        int m = a.length();
        int n = b.length();
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int aIndex = m - i - 1;
            int aNum = a.charAt(aIndex) - '0';
            int bIndex = n - i - 1;
            int bNum = 0;
            if (bIndex >= 0) {
                bNum = b.charAt(bIndex) - '0';
            }
            int sum = carry + aNum + bNum;
            int currentNum = sum % 2;
            carry = sum / 2;
            result.append(currentNum);
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    /**
     * Solution 2
     */
    public String addBinary2(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i -= 1;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j -= 1;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(new AddBinary().addBinary(a, b));
        System.out.println(new AddBinary().addBinary2(a, b));
    }
}
