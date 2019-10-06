#include <iostream>
#include <vector>

using namespace std;

bool search(vector<int>& nums, int target) {
    if (nums.empty()) {
        return false;
    }
    int start = 0;
    int end = nums.size() - 1;
    while (start + 1 < end) {
        int mid = (start + end) / 2;
        int start_value = nums[start];
        if (nums[mid] > start_value) {
            if (target >= nums[mid]) {
                start = mid;
            } else if (target >= start_value) {
                end = mid;
            } else {
                start = mid;
            }
        } else if (nums[mid] < start_value) {
            if (target <= nums[mid]) {
                end = mid;
            } else if (target < start_value) {
                start = mid;
            } else {
                end = mid;
            }
        } else {
            start += 1;
        }
    }
    return (nums[start] == target || nums[end] == target);
}

int main() {
    vector<int> nums = {2, 5, 6, 0, 0, 1, 2};
    int target = 0;
    cout << search(nums, target);
    return 0;
}