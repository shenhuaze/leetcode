#include <iostream>
#include <vector>

using namespace std;


int FindKth(vector<int>& nums1, int i, vector<int>& nums2, int j, int k) {
    if (i >= nums1.size()) {
        return nums2[j + k - 1];
    }
    if (j >= nums2.size()) {
        return nums1[i + k - 1];
    }
    if (k == 1) {
        return min(nums1[i], nums2[j]);
    }
    int mid_val1;
    if (i + k / 2 - 1 < nums1.size()) {
        mid_val1 = nums1[i + k / 2 - 1];
    } else {
        mid_val1 = INT_MAX;
    }
    int mid_val2;
    if (j + k / 2 - 1 < nums2.size()) {
        mid_val2 = nums2[j + k / 2 - 1];
    } else {
        mid_val2 = INT_MAX;
    }
    if (mid_val1 < mid_val2) {
        return FindKth(nums1, i + k / 2, nums2, j, k - k / 2);
    } else {
        return FindKth(nums1, i, nums2, j + k / 2, k - k / 2);
    }
}

double FindMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    int m = nums1.size();
    int n = nums2.size();
    int left = (m + n + 1) / 2;
    int right = (m + n + 2) / 2;
    return (FindKth(nums1, 0, nums2, 0, left) + FindKth(nums1, 0, nums2, 0, right)) / 2.0;
}


int main() {
    vector<int> nums1 = {1, 3};
    vector<int> nums2 = {2};
    double median = FindMedianSortedArrays(nums1, nums2);
    cout << median;
    return 0;
}