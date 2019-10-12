package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-10-06
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }
            result = Math.max(result, largestRectangleArea(heights));
        }
        return result;
    }

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
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(new MaximalRectangle().maximalRectangle(matrix));
    }
}
