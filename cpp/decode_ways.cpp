#include <iostream>
#include <vector>

using namespace std;

int NumDecodings(string s) {
    if (s.empty() || s[0] == '0') {
        return 0;
    }
    int length = s.size();
    vector<int> dp(length + 1);
    dp[0] = 1;
    for (int i = 1; i < length + 1; i++) {
        if (s[i - 1] != '0') {
            dp[i] = dp[i - 1];
        } else {
            dp[i] = 0;
        }
        if (i == 1) {
            continue;
        }
        if (s[i - 2] == '1') {
            dp[i] += dp[i - 2];
        }
        if (s[i - 2] == '2' && s[i - 1] <= '6') {
            dp[i] += dp[i - 2];
        }
    }
    return dp[length];
}

int main() {
    string s = "226";
    cout << NumDecodings(s);
    return 0;
}