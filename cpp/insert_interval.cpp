#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> Insert(vector<vector<int>>& intervals, vector<int>& new_interval) {
    if (intervals.empty() || intervals[0].empty()) {
        return {new_interval};
    }
    if (new_interval.empty()) {
        return intervals;
    }
    vector<vector<int>> results;
    int new_start = new_interval[0];
    int new_end = new_interval[1];
    int index = 0;
    int size = (int)intervals.size();
    while (index < size && intervals[index][0] < new_start) {
        results.push_back(intervals[index]);
        index += 1;
    }
    if (results.empty() || results[results.size() - 1][1] < new_start) {
        results.push_back(new_interval);
    } else {
        int last_index = (int)results.size() - 1;
        int last_end = results[last_index][1];
        results[last_index][1] = max(last_end, new_end);
    }
    while (index < size) {
        vector<int> interval = intervals[index];
        int last_index = (int)results.size() - 1;
        int last_end = results[last_index][1];
        if (last_end < interval[0]) {
            results.push_back(interval);
        } else {
            results[last_index][1] = max(last_end, interval[1]);
        }
        index += 1;
    }
    return results;
}

int main() {
    vector<vector<int>> intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    vector<int> new_interval = {4, 8};
    vector<vector<int>> results = Insert(intervals, new_interval);
    for (vector<int> result : results) {
        cout << result[0] << " " << result[1] << "\n";
    }
    return 0;
}