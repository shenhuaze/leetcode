package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-06-15
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1;
        if (i + k / 2 - 1 < nums1.length) {
            midVal1 = nums1[i + k / 2 - 1];
        } else {
            midVal1 = Integer.MAX_VALUE;
        }
        int midVal2;
        if (j + k / 2 - 1 < nums2.length) {
            midVal2 = nums2[j + k / 2 - 1];
        } else {
            midVal2 = Integer.MAX_VALUE;
        }
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        //int[] nums1 = {1, 3};
        //int[] nums2 = {2};
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double median = new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}
