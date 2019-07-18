#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-07-18
 */
void Helper(vector<vector<int>> &results, vector<int> &combination, vector<int> &candidates, int start_index,
            int remain_target) {
    if (remain_target == 0) {
        results.push_back(combination);
        return;
    }
    for (int i = start_index; i < candidates.size(); i++) {
        if (candidates[i] > remain_target) {
            return;
        }
        combination.push_back(candidates[i]);
        Helper(results, combination, candidates, i, remain_target - candidates[i]);
        combination.pop_back();
    }
}

vector<vector<int>> CombinationSum(vector<int>& candidates, int target) {
    vector<vector<int>> results;
    if (candidates.empty()) {
        return results;
    }
    sort(candidates.begin(), candidates.end());
    vector<int> combination;
    Helper(results, combination, candidates, 0, target);
    return results;
}

int main() {
    vector<int> candidates = {3, 2, 6, 7};
    int target = 7;
    vector<vector<int>> results = CombinationSum(candidates, target);
    for (vector<int> result : results) {
        for (int i : result) {
            cout << i << " ";
        }
        cout << "\n";
    }
    return 0;
}