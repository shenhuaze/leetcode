#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> Subsets(vector<int>& nums) {
    vector<vector<int>> results(1);
    for (int i = 0; i < nums.size(); i++) {
        int size = results.size();
        for (int j = 0; j < size; j++) {
            results.push_back(results[j]);
            results[j].push_back(nums[i]);
        }
    }
    return results;
}

int main() {
    vector<int> nums = {1, 2, 3};
    vector<vector<int>> results = Subsets(nums);
    for (vector<int> result : results) {
        for (int i : result) {
            cout << i << " ";
        }
        cout << "\n";
    }
    return 0;
}