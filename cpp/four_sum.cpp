#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> FourSum(vector<int>& nums, int target) {
    vector<vector<int>> results;
    if (nums.empty() || nums.size() < 4) {
        return results;
    }
    sort(nums.begin(), nums.end());
    for (int i = 0; i < nums.size() - 3; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }
        for (int j = i + 1; j < nums.size() - 2; j++) {
            if (j > i + 1 && nums[j] == nums[j - 1]) {
                continue;
            }
            int left = j + 1;
            int right = nums.size() - 1;
            while (left < right) {
                int sum = nums[i] + nums[j] + nums[left] + nums[right];
                if (sum == target) {
                    results.push_back({nums[i], nums[j], nums[left], nums[right]});
                    left += 1;
                    right -= 1;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right -= 1;
                    }
                } else if (sum < target) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
    }
    return results;
}

int main() {
    vector<int> nums = {1, 0, -1, 0, -2, 2};
    int target = 0;
    vector<vector<int>> results = FourSum(nums, target);
    for (vector<int> result : results) {
        for (int i : result) {
            cout << i << " ";
        }
        cout << "\n";
    }
    return 0;
}