package com.huaze.shen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-10-26
 */
public class SubsetsII {
    /**
     * Solution 1
     * Recursion
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(results, result, nums, 0);
        return results;
    }

    private void helper(List<List<Integer>> results, List<Integer> result, int[] nums, int startIndex) {
        results.add(new ArrayList<>(result));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            result.add(nums[i]);
            helper(results, result, nums, i + 1);
            result.remove(result.size() - 1);
        }
    }

    /**
     * Solution 2
     * Non-recursion
     */
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        results.add(new ArrayList<>());
        int lastNum = nums[0];
        int lastStartSize = 1;
        for (int num: nums) {
            int size = results.size();
            int startIndex = 0;
            if (num == lastNum) {
                startIndex = size - lastStartSize;
            } else {
                lastNum = num;
                lastStartSize = results.size();
            }
            for (int j = startIndex; j < size; j++) {
                List<Integer> result = new ArrayList<>(results.get(j));
                result.add(num);
                results.add(result);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        //List<List<Integer>> results = new SubsetsII().subsetsWithDup(nums);
        List<List<Integer>> results = new SubsetsII().subsetsWithDup2(nums);
        for (List<Integer> result: results) {
            System.out.println(result);
        }
    }
}
