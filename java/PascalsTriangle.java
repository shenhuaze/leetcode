package com.huaze.shen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2020-02-02
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        List<Integer> lastRow = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                row = new ArrayList<>();
                row.add(1);
                results.add(row);
            }
            if (i == 1) {
                row = new ArrayList<>();
                row.add(1);
                row.add(1);
                results.add(row);
            }
            if (i >= 2) {
                lastRow = results.get(i - 1);
                row = new ArrayList<>();
                row.add(1);
                for (int j = 0; j < i - 1; j++) {
                    row.add(lastRow.get(j) + lastRow.get(j + 1));
                }
                row.add(1);
                results.add(row);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<List<Integer>> results = new PascalsTriangle().generate(5);
        for (List<Integer> row: results) {
            System.out.println(row);
        }
    }
}
