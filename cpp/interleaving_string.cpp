#include <iostream>
#include <vector>

using namespace std;

bool IsInterleave(string s1, string s2, string s3) {
    if (s1.size() + s2.size() != s3.size()) {
        return false;
    }
    int n1 = s1.size();
    int n2 = s2.size();
    vector<vector<bool>> dp(n1 + 1, vector<bool>(n2 + 1));
    dp[0][0] = true;
    for (int i = 1; i <= n1; i++) {
        if (dp[i - 1][0] && s1[i - 1] == s3[i - 1]) {
            dp[i][0] = true;
        }
    }
    for (int i = 1; i <= n2; i++) {
        if (dp[0][i - 1] && s2[i - 1] == s3[i - 1]) {
            dp[0][i] = true;
        }
    }
    for (int i = 1; i <= n1; i++) {
        for (int j = 1; j <= n2; j++) {
            if (dp[i - 1][j] && s1[i - 1] == s3[i + j - 1]) {
                dp[i][j] = true;
            }
            if (dp[i][j - 1] && s2[j - 1] == s3[i + j - 1]) {
                dp[i][j] = true;
            }
        }
    }
    return dp[n1][n2];
}

int main() {
    string s1 = "aabcc";
    string s2 = "dbbca";
    string s3 = "aadbbcbcac";
    cout << IsInterleave(s1, s2, s3);
    return 0;
}