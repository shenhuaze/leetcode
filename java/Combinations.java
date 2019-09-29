package com.huaze.shen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-09-28
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        helper(results, result, 1, n, k);
        return results;
    }

    private void helper(List<List<Integer>> results, List<Integer> result, int level, int n, int k) {
        if (result.size() == k) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = level; i <= n; i++) {
            result.add(i);
            helper(results, result, i + 1, n, k);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        List<List<Integer>> results = new Combinations().combine(n, k);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }
}
