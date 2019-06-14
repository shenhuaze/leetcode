#include <iostream>
#include <map>

using namespace std;

int LengthOfLongestSubstring(string s) {
    map<char, int> char_positions;
    int left = -1;
    int max_len = 0;
    for (int i = 0; i < s.length(); i++) {
        char ch = s[i];
        if (char_positions.count(ch) && char_positions[ch] > left) {
            left = char_positions[ch];
        }
        char_positions[ch] = i;
        max_len = max(max_len, i - left);
    }
    return max_len;
}

int main() {
    string s = "abcabcbb";
    int max_len = LengthOfLongestSubstring(s);
    cout << max_len;
    return 0;
}