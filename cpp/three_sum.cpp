#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> ThreeSum(vector<int>& nums) {
    vector<vector<int>> results;
    if (nums.empty() || nums.size() < 3) {
        return results;
    }
    sort(nums.begin(), nums.end());
    for (int i = 0; i < nums.size() - 2; i++) {
        if (nums[i] > 0) {
            break;
        }
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }
        int target = -nums[i];
        int left = i + 1;
        int right = nums.size() - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                results.push_back({nums[i], nums[left], nums[right]});
                left += 1;
                right -= 1;
                while (left < right && nums[left] == nums[left - 1]) {
                    left += 1;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right -= 1;
                }
            } else if (nums[left] + nums[right] < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }
    }
    return results;
}

int main() {
    //vector<int> nums = {-1, 0, 1, 2, -1, -4};
    vector<int> nums = {0, 0, 0};
    vector<vector<int>> results = ThreeSum(nums);
    for (vector<int> result : results) {
        for (int i : result) {
            cout << i << " ";
        }
        cout << "\n";
    }
    return 0;
}