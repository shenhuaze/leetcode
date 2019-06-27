package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-06-27
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < height.length && right > left) {
            int area = computeArea(left, right, height);
            if (area > max) {
                max = area;
            }
            if (height[left] < height[right]) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return max;
    }

    private int computeArea(int left, int right, int[] height) {
        int width = right - left;
        int leftHeight = height[left];
        int rightHeight = height[right];
        int minHeight = Math.min(leftHeight, rightHeight);
        return width * minHeight;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }
}
