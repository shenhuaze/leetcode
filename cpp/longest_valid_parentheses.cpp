#include <iostream>
#include <stack>
#include <vector>

using namespace std;

// Solution 1
bool IsValid(string s) {
    stack<char> m;
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == '(') {
            m.push('(');
        } else if (!m.empty()) {
            m.pop();
        } else {
            return false;
        }
    }
    return m.empty();
}

int LongestValidParentheses(string s) {
    int max_len = 0;
    for (int i = 0; i < s.size(); i++) {
        for (int j = i + 2; j <= s.size(); j++) {
            if (IsValid(s.substr(i, j - i))) {
                max_len = max(max_len, j - i);
            }
        }
    }
    return max_len;
}


// Solution 2
int LongestValidParentheses2(string s) {
    int max_len = 0;
    int start = 0;
    stack<int> m;
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == '(') {
            m.push(i);
        } else {
            if (m.empty()) {
                start = i + 1;
            } else {
                m.pop();
                if (m.empty()) {
                    max_len = max(max_len, i - start + 1);
                } else {
                    max_len = max(max_len, i - m.top());
                }
            }
        }
    }
    return max_len;
}


// Solution 3
int LongestValidParentheses3(string s) {
    int max_len = 0;
    vector<int> dp(s.size());
    for (int i = 1; i < s.size(); i++) {
        if (s[i] == ')') {
            if (s[i - 1] == '(') {
                if (i >= 2) {
                    dp[i] = dp[i - 2] + 2;
                } else {
                    dp[i] = 2;
                }
            } else if (i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] == '(') {
                if (i - dp[i - 1] >= 2) {
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                } else {
                    dp[i] = dp[i - 1] + 2;
                }
            }
            max_len = max(max_len, dp[i]);
        }
    }
    return max_len;
}


int LongestValidParentheses4(string s) {
    int max_len = 0;
    int left = 0;
    int right = 0;
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == '(') {
            left += 1;
        } else {
            right += 1;
        }
        if (left == right) {
            max_len = max(max_len, left * 2);
        } else if (right > left) {
            left = 0;
            right = 0;
        }
    }
    left = 0;
    right = 0;
    for (int i = (int)s.size() - 1; i >= 0; i--) {
        if (s[i] == '(') {
            left += 1;
        } else {
            right += 1;
        }
        if (left == right) {
            max_len = max(max_len, left * 2);
        } else if (left > right) {
            left = 0;
            right = 0;
        }
    }
    return max_len;
}


int main() {
    string s = "(()";
    cout << LongestValidParentheses(s) << "\n";
    cout << LongestValidParentheses2(s) << "\n";
    cout << LongestValidParentheses3(s) << "\n";
    cout << LongestValidParentheses4(s) << "\n";
    return 0;
}