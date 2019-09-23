package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-09-22
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (matrix[mid / n][mid % n] < target) {
                start = mid;
            } else if (matrix[mid / n][mid % n] > target) {
                end = mid;
            } else {
                return true;
            }
        }
        return (matrix[start / n][start % n] == target || matrix[end / n][end % n] == target);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        //int[][] matrix = {{1}};
        int target = 3;
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, target));
    }
}
