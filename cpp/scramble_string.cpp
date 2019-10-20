#include <iostream>
#include <vector>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-10-19
 */
bool IsScramble(string s1, string s2) {
    if (s1.empty() || s2.empty()) {
        return false;
    }
    if (s1.size() != s2.size()) {
        return false;
    }
    if (s1 == s2) {
        return true;
    }
    vector<int> letters(26);
    for (int i = 0; i < s1.size(); i++) {
        letters[s1[i] - 'a'] += 1;
        letters[s2[i] - 'a'] -= 1;
    }
    for (int i = 0; i < 26; i++) {
        if (letters[i] != 0) {
            return false;
        }
    }
    for (int i = 1; i < s1.size(); i++) {
        if (IsScramble(s1.substr(0, i), s2.substr(0, i)) && IsScramble(s1.substr(i), s2.substr(i))) {
            return true;
        }
        if (IsScramble(s1.substr(0, i), s2.substr(s2.size() - i)) && IsScramble(s1.substr(i), s2.substr(0, s2.size() - i))) {
            return true;
        }
    }
    return false;
}

int main() {
    string s1 = "great";
    string s2 = "rgeat";
    cout << IsScramble(s1, s2);
    return 0;
}