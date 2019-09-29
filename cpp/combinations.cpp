#include <iostream>
#include <vector>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-09-28
 */

void Helper(vector<vector<int>>& results, vector<int>& result, int level, int n, int k) {
    if (result.size() == k) {
        results.push_back(result);
        return;
    }
    for (int i = level; i <= n; i++) {
        result.push_back(i);
        Helper(results, result, i + 1, n, k);
        result.pop_back();
    }
}

vector<vector<int>> Combine(int n, int k) {
    vector<vector<int>> results;
    vector<int> result;
    Helper(results, result, 1, n, k);
    return results;
}


int main() {
    vector<vector<int>> results = Combine(5, 3);
    for (vector<int> result: results) {
        for (int i : result) {
            cout << i << " ";
        }
        cout << "\n";
    }
    return 0;
}