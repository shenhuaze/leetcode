package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-06-17
 */
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (Math.abs(result) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        //int x = 123;
        int x = -123;
        int result = new ReverseInteger().reverse(x);
        System.out.println(result);
    }
}
