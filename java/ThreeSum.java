package com.huaze.shen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-06-28
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            twoSum(target, start, end, nums, results);
        }
        return results;
    }

    private void twoSum(int target, int start, int end, int[] nums, List<List<Integer>> results) {
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                List<Integer> result = new ArrayList<>();
                result.add(-target);
                result.add(nums[start]);
                result.add(nums[end]);
                results.add(result);
                start += 1;
                end -= 1;
                while (start < end && nums[start] == nums[start - 1]) {
                    start += 1;
                }
                while (start < end && nums[end] == nums[end + 1]) {
                    end -= 1;
                }
            } else if (nums[start] + nums[end] < target) {
                start += 1;
            } else {
                end -= 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(nums));
    }
}
