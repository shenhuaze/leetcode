package com.huaze.shen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-07-27
 */
public class NQueensII {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        List<Integer> countList = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        search(cols, countList, n);
        return countList.size();
    }

    private void search(List<Integer> cols, List<Integer> countList, int n) {
        if (cols.size() == n) {
            countList.add(1);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(cols, i)) {
                continue;
            }
            cols.add(i);
            search(cols, countList, n);
            cols.remove((cols.size() - 1));
        }
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
        System.out.println(new NQueensII().totalNQueens(4));
    }
}
