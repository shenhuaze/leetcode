package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-10-19
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i -= 1;
                k -= 1;
            } else {
                nums1[k] = nums2[j];
                j -= 1;
                k -= 1;
            }
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            j -= 1;
            k -= 1;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        new MergeSortedArray().merge(nums1, m, nums2, n);
        for (int i: nums1) {
            System.out.println(i);
        }
    }
}
