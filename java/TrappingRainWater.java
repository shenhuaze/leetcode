package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-19
 */
public class TrappingRainWater {
    /**
     * Solution 1: Brute force
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(height[j], maxLeft);
            }
            for (int j = i; j < height.length; j++) {
                maxRight = Math.max(height[j], maxRight);
            }
            result += Math.min(maxLeft, maxRight) - height[i];
        }
        return result;
    }

    /**
     * Solution 2: Dynamic programming
     */
    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = 0;
        int size = height.length;
        int[] maxLeft = new int[size];
        maxLeft[0] = height[0];
        for (int i = 1; i < size; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        int[] maxRight = new int[size];
        maxRight[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        for (int i = 0; i < size; i++) {
            result += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //System.out.println(new TrappingRainWater().trap(height));
        System.out.println(new TrappingRainWater().trap2(height));
    }
}
