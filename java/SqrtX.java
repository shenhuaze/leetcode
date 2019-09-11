package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-09-09
 */
public class SqrtX {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0;
        int right = x;
        while (left + 1 < right) {
            // 不使用mid = (left + right) / 2，是为了防止溢出
            int mid = left + (right - left) / 2;
            // 不使用mid * mid < x，是为了防止溢出
            if (x / mid > mid) {
                left = mid;
            } else if (x / mid < mid) {
                right = mid;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new SqrtX().mySqrt(2147395599));
    }
}
