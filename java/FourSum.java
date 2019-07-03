package com.huaze.shen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-07-03
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[left]);
                        result.add(nums[right]);
                        results.add(result);
                        left += 1;
                        right -= 1;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left += 1;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right -= 1;
                        }
                    } else if (sum < target) {
                        left += 1;
                    } else {
                        right -= 1;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        //int[] nums = {0, 0, 0, 0};
        int target = 0;
        System.out.println(new FourSum().fourSum(nums, target));
    }
}
