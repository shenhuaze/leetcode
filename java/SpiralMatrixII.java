package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-08-12
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] results = new int[n][n];
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = n - 1;
        int currentNum = 1;
        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                results[up][i] = currentNum++;
            }
            for (int i = up + 1; i <= down; i++) {
                results[i][right] = currentNum++;
            }
            for (int i = right - 1; i >= left; i--) {
                results[down][i] = currentNum++;
            }
            for (int i = down - 1; i >= up + 1; i--) {
                results[i][left] = currentNum++;
            }
            left += 1;
            right -= 1;
            up += 1;
            down -= 1;
        }
        if (up == down) {
            for (int i = left; i <= right; i++) {
                results[up][i] = currentNum++;
            }
        } else if (left == right) {
            for (int i = up; i <= down; i++) {
                results[i][left] = currentNum++;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] results = new SpiralMatrixII().generateMatrix(n);
        for (int[] row : results) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
