#include <iostream>
#include <vector>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-07-16
 */
int SearchInsert(vector<int>& nums, int target) {
    if (nums.empty()) {
        return 0;
    }
    int start = 0;
    int end = nums.size() - 1;
    while (start + 1 < end) {
        int mid = (start + end) / 2;
        if (target > nums[mid]) {
            start = mid;
        } else if (target < nums[mid]) {
            end = mid;
        } else {
            return mid;
        }
    }
    if (target <= nums[start]) {
        return start;
    } else if (target <= nums[end]) {
        return end;
    } else {
        return end + 1;
    }
}

int main() {
    vector<int> nums = {1, 3, 5, 6};
    int target = 5;
    cout << SearchInsert(nums, target);
    return 0;
}