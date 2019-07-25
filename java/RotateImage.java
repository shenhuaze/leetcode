package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-25
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            int range = end - start;
            for (int i = 0; i < range; i++) {
                int temp = matrix[start][start + i];
                matrix[start][start + i] = matrix[end - i][start];
                matrix[end- i][start] = matrix[end][end - i];
                matrix[end][end - i] = matrix[start + i][end];
                matrix[start + i][end] = temp;
            }
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        //int[][] matrix = {
        //        {1, 2, 3},
        //        {4, 5, 6},
        //        {7, 8, 9}
        //};
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        new RotateImage().rotate(matrix);
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
