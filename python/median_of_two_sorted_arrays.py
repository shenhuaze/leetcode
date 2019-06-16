import sys


def find_median_sorted_arrays(nums1, nums2):
    m = len(nums1)
    n = len(nums2)
    left = (m + n + 1) // 2
    right = (m + n + 2) // 2
    return (find_kth(nums1, 0, nums2, 0, left) + find_kth(nums1, 0, nums2, 0, right)) / 2.0


def find_kth(nums1, i, nums2, j, k):
    if i >= len(nums1):
        return nums2[j + k - 1]
    if j >= len(nums2):
        return nums1[i + k - 1]
    if k == 1:
        return min(nums1[i], nums2[j])
    if i + k // 2 - 1 < len(nums1):
        mid_val1 = nums1[i + k // 2 - 1]
    else:
        mid_val1 = sys.maxsize
    if j + k // 2 - 1 < len(nums2):
        mid_val2 = nums2[j + k // 2 - 1]
    else:
        mid_val2 = sys.maxsize
    if mid_val1 < mid_val2:
        return find_kth(nums1, i + k // 2, nums2, j, k - k // 2)
    else:
        return find_kth(nums1, i, nums2, j + k // 2, k - k // 2)


if __name__ == "__main__":
    nums1_ = [1, 3]
    nums2_ = [2]
    median = find_median_sorted_arrays(nums1_, nums2_)
    print(median)
