#include <iostream>

using namespace std;


bool IsMatchRecursion(string s, string p) {
    if (p.empty()) {
        return s.empty();
    } else if (p.size() == 1) {
        return s.size() == 1 && (s[0] == p[0] || '.' == p[0]);
    } else if (p[1] != '*') {
        if (s.empty()) {
            return false;
        }
        return (s[0] == p[0] || '.' == p[0]) && IsMatchRecursion(s.substr(1, s.size() - 1), p.substr(1, p.size() - 1));
    } else {
        while (!s.empty() && (s[0] == p[0] || '.' == p[0])) {
            if (IsMatchRecursion(s, p.substr(2, p.size() - 2))) {
                return true;
            }
            s = s.substr(1, s.size() - 1);
        }
    }
    return IsMatchRecursion(s, p.substr(2, p.size() - 2));
}

bool IsMatchDp(string s, string p) {
    int m = s.size();
    int n = p.size();
    bool dp[m + 1][n + 1];
    for(int i = 0; i < m + 1; i++) {
        for (int j = 0; j < n + 1; j++) {
            dp[i][j] = false;
        }
    }
    dp[0][0] = true;
    for (int i = 1; i < n; i++) {
        if (p[i] == '*' && dp[0][i - 1]) {
            dp[0][i + 1] = true;
        }
    }
    for (int i = 1; i < m + 1; i++) {
        for (int j = 1; j < n + 1; j++) {
            if (p[j - 1] == '.' || p[j - 1] == s[i - 1]) {
                dp[i][j] = dp[i - 1][j - 1];
            }
            if (p[j - 1] == '*') {
                if (p[j - 2] != s[i - 1] && p[j - 2] != '.') {
                    dp[i][j] = dp[i][j - 2];
                } else {
                    dp[i][j] = (dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j]);
                }
            }
        }
    }
    return dp[m][n];
}

bool IsMatch(string s, string p) {
    //return IsMatchRecursion(s, p);
    return IsMatchDp(s, p);
}


int main() {
    string s = "aab";
    string p = "c*a*b";
    cout << IsMatch(s, p);
    return 0;
}