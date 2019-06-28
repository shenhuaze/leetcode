#include <iostream>
#include <vector>

using namespace std;

string LongestCommonPrefix(vector<string>& strs) {
    if (strs.empty()) {
        return "";
    }
    for (int i = 0; i < strs[0].size(); i++) {
        for (int j = 1; j < strs.size(); j++) {
            if (i >= strs[j].length() || strs[j][i] != strs[0][i]) {
                return strs[0].substr(0, i);
            }
        }
    }
    return strs[0];
}

int main() {
    vector<string> strs = {"flower", "flow", "flight"};
    cout << LongestCommonPrefix(strs);
    return 0;
}