package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-10
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int ans = 0;
        boolean isSameSign = (dividend > 0) == (divisor > 0);
        while (dvd >= dvs) {
            long temp = dvs;
            long m = 1;
            while (temp << 1 <= dvd) {
                temp <<= 1;
                m <<= 1;
            }
            dvd -= temp;
            ans += m;
        }
        return isSameSign ? ans : -ans;
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        System.out.println(new DivideTwoIntegers().divide(dividend, divisor));
    }
}
