#include <iostream>
#include <vector>
#include <set>

using namespace std;

void Helper(vector<vector<int>>& results, vector<int>& permutation, vector<int>& nums, set<int>& used_index_set) {
    if (permutation.size() == nums.size()) {
        results.push_back(permutation);
        return;
    }
    for (int i = 0; i < nums.size(); i++) {
        if (used_index_set.count(i)) {
            continue;
        }
        permutation.push_back(nums[i]);
        used_index_set.insert(i);
        Helper(results, permutation, nums, used_index_set);
        permutation.pop_back();
        used_index_set.erase(i);
    }
}

vector<vector<int>> Permute(vector<int>& nums) {
    vector<vector<int>> results;
    if (nums.empty()) {
        return results;
    }
    vector<int> permutation;
    set<int> used_index_set;
    Helper(results, permutation, nums, used_index_set);
    return results;
}

int main() {
    vector<int> nums = {1, 2, 3};
    vector<vector<int>> results = Permute(nums);
    for (vector<int> result : results) {
        for (int i : result) {
            cout << i << " ";
        }
        cout << "\n";
    }
    return 0;
}