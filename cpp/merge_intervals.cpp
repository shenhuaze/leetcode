#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

static bool Compare(vector<int>& a, vector<int>& b) {
    return a[0] < b[0];
    //return a[1] < b[1];
}

vector<vector<int>> Merge(vector<vector<int>>& intervals) {
    vector<vector<int>> results;
    if (intervals.empty() || intervals[0].empty()) {
        return results;
    }
    sort(intervals.begin(), intervals.end(), Compare);
    results.push_back(intervals[0]);
    for (int i = 1; i < intervals.size(); i++) {
        if (intervals[i][0] > results.back()[1]) {
            results.push_back(intervals[i]);
        } else {
            results.back()[1] = max(results.back()[1], intervals[i][1]);
        }
    }
    return results;
}

int main() {
    vector<vector<int>> intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    //vector<vector<int>> intervals = {{1, 3}, {2, 6}, {16, 17}, {15, 18}};
    vector<vector<int>> results = Merge(intervals);
    for (vector<int> interval : results) {
        cout << interval[0] << " " << interval[1] << "\n";
    }
    return 0;
}