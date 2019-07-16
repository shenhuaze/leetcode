#include <iostream>
#include <vector>

using namespace std;

int Search(vector<int>& nums, int target) {
    if (nums.empty()) {
        return -1;
    }
    int start = 0;
    int end = nums.size() - 1;
    while (start + 1 < end) {
        int mid = (start + end) / 2;
        int start_value = nums[start];
        if (nums[mid] >= start_value) {
            if (target >= nums[mid]) {
                start = mid;
            } else if (target >= start_value) {
                end = mid;
            } else {
                start = mid;
            }
        } else {
            if (target <= nums[mid]) {
                end = mid;
            } else if (target < start_value) {
                start = mid;
            } else {
                end = mid;
            }
        }
    }
    if (nums[start] == target) {
        return start;
    }
    if (nums[end] == target) {
        return end;
    }
    return -1;
}

int main() {
    vector<int> nums = {4, 5, 6, 7, 0, 1, 2};
    int target = 0;
    cout << Search(nums, target);
    return 0;
}