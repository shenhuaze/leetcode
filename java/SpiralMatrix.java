package com.huaze.shen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-08-01
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        while (up < down && left < right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            for (int i = right - 1; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1; i--) {
                result.add(matrix[i][left]);
            }
            up += 1;
            down -= 1;
            left += 1;
            right -= 1;
        }
        if (up == down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
        } else if (left == right) {
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][left]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //int[][] matrix = new int[][]{
        //        {1, 2, 3},
        //        {4, 5, 6},
        //        {7, 8, 9}
        //};
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }
}
