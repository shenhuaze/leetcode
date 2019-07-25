#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-07-25
 */
vector<vector<string>> GroupAnagrams(vector<string>& strs) {
    vector<vector<string>> results;
    if (strs.empty()) {
        return results;
    }
    unordered_map<string, vector<string>> dic;
    for (string str : strs) {
        string new_str = str;
        sort(new_str.begin(), new_str.end());
        dic[new_str].push_back(str);
    }
    for (auto d : dic) {
        results.push_back(d.second);
    }
    return results;
}

int main() {
    vector<string> strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    vector<vector<string>> results = GroupAnagrams(strs);
    for (vector<string> each : results) {
        for (string s: each) {
            cout << s << " ";
        }
        cout << "\n";
    }
    return 0;
}