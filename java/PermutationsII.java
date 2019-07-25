package com.huaze.shen;

import java.util.*;

/**
 * @author Huaze Shen
 * @date 2019-07-25
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        List<Integer> permutation = new ArrayList<>();
        helper(results, permutation, nums, visited);
        return results;
    }

    private void helper(List<List<Integer>> results, List<Integer> permutation, int[] nums, int[] visited) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i > 0 && visited[i - 1] == 0 && nums[i] == nums[i - 1])) {
                continue;
            }
            visited[i] = 1;
            permutation.add(nums[i]);
            helper(results, permutation, nums, visited);
            permutation.remove(permutation.size() - 1);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new PermutationsII().permuteUnique(nums));
    }
}
