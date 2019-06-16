#include <iostream>

using namespace std;

void SearchPalindrome(string s, int left, int right, int& start, int& max_len) {
    while (left >= 0 && right < s.size() && s[left] == s[right]) {
        left -= 1;
        right += 1;
    }
    if (max_len < right - left - 1) {
        start = left + 1;
        max_len = right - left - 1;
    }
}

// Solution 1
string LongestPalindrome(string s) {
    if (s.size() < 2) {
        return s;
    }
    int start = 0;
    int max_len = 0;
    for (int i = 0; i < s.size(); i++) {
        SearchPalindrome(s, i, i, start, max_len);
        SearchPalindrome(s, i, i + 1, start, max_len);
    }
    return s.substr(start, max_len);
}

// Solution 2
string LongestPalindrome2(string s) {
    if (s.size() < 2) {
        return s;
    }
    int start = 0;
    int max_len = 0;
    int i = 0;
    while (i < s.size()) {
        if (max_len / 2 > s.size() - i) {
            break;
        }
        int left = i;
        int right = i;
        while (right < s.size() && s[right] == s[right + 1]) {
            right += 1;
        }
        i = right + 1;
        SearchPalindrome(s, left, right, start, max_len);
    }
    return s.substr(start, max_len);
}

int main() {
    string s = "dcbab";
    //cout << LongestPalindrome(s);
    cout << LongestPalindrome2(s);
    return 0;
}