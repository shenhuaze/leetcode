#include <iostream>
#include <vector>

using namespace std;

void dfs(vector<string>& results, int left, int right, string current, int n) {
    if (left < right) {
        return;
    }
    if (left == n && right == n) {
        results.push_back(current);
    }
    if (left < n) {
        dfs(results, left + 1, right, current + "(", n);
    }
    if (right < n) {
        dfs(results, left, right + 1, current + ")", n);
    }
}

vector<string> GenerateParenthesis(int n) {
    vector<string> results;
    dfs(results, 0, 0, "", n);
    return results;
}


int main() {
    vector<string> results = GenerateParenthesis(3);
    for (string result : results) {
        cout << result << "\n";
    }
    return 0;
}