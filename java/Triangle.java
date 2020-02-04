package com.huaze.shen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2020-02-04
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] row = new int[m];
        row[0] = triangle.get(0).get(0);
        int totalMin = row[0];
        for (int i = 1; i < m; i++) {
            totalMin = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                int min;
                if (j == 0) {
                    min = row[j];
                } else if (j == i) {
                    min = row[j - 1];
                } else {
                    min = Math.min(row[j - 1], row[j]);
                }
                row[j] = min + triangle.get(i).get(j);
                if (row[j] < totalMin) {
                    totalMin = row[j];
                }
            }
        }
        return totalMin;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row0 = new ArrayList<>();
        row0.add(2);
        List<Integer> row1 = new ArrayList<>();
        row1.add(3);
        row1.add(4);
        List<Integer> row2 = new ArrayList<>();
        row2.add(6);
        row2.add(5);
        row2.add(7);
        List<Integer> row3 = new ArrayList<>();
        row3.add(4);
        row3.add(1);
        row3.add(8);
        row3.add(3);
        triangle.add(row0);
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        System.out.println(new Triangle().minimumTotal(triangle));
    }
}
