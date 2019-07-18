package com.huaze.shen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-07-18
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();
        helper(results, combination, candidates, 0, target);
        return results;
    }

    private void helper(List<List<Integer>> results,
                        List<Integer> combination,
                        int[] candidates,
                        int startIndex,
                        int remainTarget) {
        if (remainTarget == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > remainTarget) {
                return;
            }
            combination.add(candidates[i]);
            helper(results, combination, candidates, i, remainTarget - candidates[i]);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(candidates, target));
    }
}
