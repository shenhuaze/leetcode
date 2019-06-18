package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-06-18
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int sign = 1;
        int base = 0;
        int i = 0;
        int n = str.length();
        while (i < n && str.charAt(i) == ' ') {
            i += 1;
        }
        if (i < n && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            if (str.charAt(i) == '-') {
                sign = -1;
            }
            i += 1;
        }
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            base = str.charAt(i) - '0' + base * 10;
            i += 1;
        }
        return sign * base;
    }

    public static void main(String[] args) {
        //String str = "   -42";
        String str = " ";
        int result = new StringToInteger().myAtoi(str);
        System.out.println(result);
    }
}
