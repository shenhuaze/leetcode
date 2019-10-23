"""
@author Huaze Shen
@date 2019-10-19
"""


def merge(nums1, m, nums2, n):
    i = m - 1
    j = n - 1
    k = m + n - 1
    while i >= 0 and j >= 0:
        if nums1[i] > nums2[j]:
            nums1[k] = nums1[i]
            i -= 1
            k -= 1
        else:
            nums1[k] = nums2[j]
            j -= 1
            k -= 1
    while j >= 0:
        nums1[k] = nums2[j]
        j -= 1
        k -= 1


if __name__ == '__main__':
    nums1_ = [1, 2, 3, 0, 0, 0]
    m_ = 3
    nums2_ = [2, 5, 6]
    n_ = 3
    merge(nums1_, m_, nums2_, n_)
    print(nums1_)
