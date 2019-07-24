#include <iostream>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-07-23
 */
bool IsMatch(string s, string p) {
    int i = 0;
    int j = 0;
    int i_star = -1;
    int j_star = -1;
    while (i < s.size()) {
        if (j < p.size() && (p[j] == s[i] || p[j] == '?')) {
            i += 1;
            j += 1;
        } else if (j < p.size() && p[j] == '*') {
            i_star = i;
            j_star = j;
            j += 1;
        } else if (i_star >= 0) {
            i = i_star + 1;
            j = j_star + 1;
            i_star += 1;
        } else {
            return false;
        }
    }
    while (j < p.size() && p[j] == '*') {
        j += 1;
    }
    return j == p.size();
}

int main() {
    string s = "abcdefgh";
    string p = "a*bcdeffh";
    cout << IsMatch(s, p);
    return 0;
}