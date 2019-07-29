package com.huaze.shen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-07-26
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        List<Integer> cols = new ArrayList<>();
        search(results, cols, n);
        return results;
    }

    private void search(List<List<String>> results, List<Integer> cols, int n) {
        if (cols.size() == n) {
            results.add(drawChessboard(cols));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(cols, i)) {
                continue;
            }
            cols.add(i);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    private List<String> drawChessboard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                if (cols.get(i) == j) {
                    row.append("Q");
                } else {
                    row.append(".");
                }
            }
            chessboard.add(row.toString());
        }
        return chessboard;
    }

    private boolean isValid(List<Integer> cols, int column) {
        int currentSize = cols.size();
        for (int i = 0; i < currentSize; i++) {
            if (cols.get(i) == column) {
                return false;
            }
            if (i + cols.get(i) == currentSize + column) {
                return false;
            }
            if (i - cols.get(i) == currentSize - column) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> results = new NQueens().solveNQueens(4);
        for (List<String> result : results) {
            for (String row : result) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
