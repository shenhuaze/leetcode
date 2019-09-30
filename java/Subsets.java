package com.huaze.shen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-09-28
 */
public class Subsets {
    /**
     * Solution 1
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(results, result, nums, 0);
        return results;
    }

    private void helper(List<List<Integer>> results, List<Integer> result, int[] nums, int startIndex) {
        results.add(new ArrayList<>(result));
        for (int i = startIndex; i < nums.length; i++) {
            result.add(nums[i]);
            helper(results, result, nums, i + 1);
            result.remove(result.size() - 1);
        }
    }

    /**
     * Solution 2
     * Non-recursion
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        results.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = results.size();
            for (int j = 0; j < size; j++) {
                results.add(new ArrayList<>(results.get(j)));
                results.get(j).add(nums[i]);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //List<List<Integer>> results = new Subsets().subsets(nums);
        List<List<Integer>> results = new Subsets().subsets2(nums);
        for (List<Integer> result: results) {
            System.out.println(result);
        }
    }
}
