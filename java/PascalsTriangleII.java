package com.huaze.shen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2020-02-03
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        int[] row = new int[rowIndex + 1];
        row[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                row[j] += row[j - 1];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i: row) {
            result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangleII().getRow(3));
    }
}
