package com.huaze.shen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Huaze Shen
 * @date 2019-07-24
 */
public class Permutations {
    /**
     * Solution 1
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        List<Integer> permutation = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        helper(results, permutation, nums, set);
        return results;
    }

    private void helper(List<List<Integer>> results, List<Integer> permutation, int[] nums, Set<Integer> set) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            permutation.add(nums[i]);
            set.add(i);
            helper(results, permutation, nums, set);
            set.remove(i);
            permutation.remove(permutation.size() - 1);
        }
    }

    /**
     * Solution 2
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        List<Integer> permutation = new ArrayList<>();
        int[] visited = new int[nums.length];
        helper2(results, permutation, nums, visited);
        return results;
    }

    private void helper2(List<List<Integer>> results, List<Integer> permutation, int[] nums, int[] visited) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = 1;
            helper2(results, permutation, nums, visited);
            visited[i] = 0;
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //System.out.println(new Permutations().permute(nums));
        System.out.println(new Permutations().permute2(nums));
    }
}
