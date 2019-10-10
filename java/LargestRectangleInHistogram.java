package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-10-06
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i < heights.length - 1 && heights[i] <= heights[i + 1]) {
                continue;
            }
            int minH = heights[i];
            for (int j = i; j >= 0; j--) {
                minH = Math.min(minH, heights[j]);
                int area = minH * (i - j + 1);
                result = Math.max(result, area);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights));
    }
}
