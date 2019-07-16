#include <iostream>
#include <vector>

using namespace std;

int FindFirstPosition(vector<int>& nums, int target) {
    int start = 0;
    int end = nums.size() - 1;
    while (start + 1 < end) {
        int mid = (start + end) / 2;
        if (target > nums[mid]) {
            start = mid;
        } else {
            end = mid;
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

int FindLastPosition(vector<int>& nums, int target) {
    int start = 0;
    int end = nums.size() - 1;
    while (start + 1 < end) {
        int mid = (start + end) / 2;
        if (target >= nums[mid]) {
            start = mid;
        } else {
            end = mid;
        }
    }
    if (nums[end] == target) {
        return end;
    }
    if (nums[start] == target) {
        return start;
    }
    return -1;
}

vector<int> SearchRange(vector<int>& nums, int target) {
    vector<int> result = {-1, -1};
    if (nums.empty()) {
        return result;
    }
    int first_position = FindFirstPosition(nums, target);
    int last_position = FindLastPosition(nums, target);
    result[0] = first_position;
    result[1] = last_position;
    return result;
}

int main() {
    vector<int> nums = {5, 7, 7, 8, 8, 10};
    int target = 8;
    vector<int> result = SearchRange(nums, target);
    for (int i : result) {
        cout << i << " ";
    }
    return 0;
}