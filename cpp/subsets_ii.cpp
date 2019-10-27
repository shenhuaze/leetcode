#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void Helper(vector<vector<int>>& results, vector<int>& result, vector<int>& nums, int start_index) {
    results.push_back(result);
    if (start_index >= nums.size()) {
        return;
    }
    for (int i = start_index; i < nums.size(); i++) {
        if (i > start_index && nums[i] == nums[i - 1]) {
            continue;
        }
        result.push_back(nums[i]);
        Helper(results, result, nums, i + 1);
        result.pop_back();
    }
}

vector<vector<int>> SubsetsWithDup(vector<int>& nums) {
    vector<vector<int>> results;
    vector<int> result;
    sort(nums.begin(), nums.end());
    Helper(results, result, nums, 0);
    return results;
}

int main() {
    vector<int> nums = {1, 2, 2};
    vector<vector<int>> results = SubsetsWithDup(nums);
    for (vector<int> result: results) {
        for (int i: result) {
            cout << i << " ";
        }
        cout << "\n";
    }
    return 0;
}