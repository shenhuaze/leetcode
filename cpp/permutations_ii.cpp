#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void Helper(vector<vector<int>>& results, vector<int>& permutation, vector<int>& nums, vector<int>& visited) {
    if (permutation.size() == nums.size()) {
        results.push_back(permutation);
        return;
    }
    for (int i = 0; i < nums.size(); i++) {
        if (visited[i] == 1) {
            continue;
        }
        if (i > 0 && visited[i - 1] == 0 && nums[i] == nums[i - 1]) {
            continue;
        }
        visited[i] = 1;
        permutation.push_back(nums[i]);
        Helper(results, permutation, nums, visited);
        visited[i] = 0;
        permutation.pop_back();
    }
}

vector<vector<int>> PermuteUnique(vector<int>& nums) {
    vector<vector<int>> results;
    if (nums.empty()) {
        return results;
    }
    sort(nums.begin(), nums.end());
    vector<int> visited(nums.size());
    vector<int> permutation;
    Helper(results, permutation, nums, visited);
    return results;
}

int main() {
    vector<int> nums = {1, 1, 2};
    vector<vector<int>> results = PermuteUnique(nums);
    for (vector<int> result : results) {
        for (int i : result) {
            cout << i << " ";
        }
        cout << "\n";
    }
    return 0;
}