#include <iostream>
#include <vector>

using namespace std;


/**
 * @author Huaze Shen
 * @date 2019-09-26
 */
string MinWindow(string s, string t) {
    string result = "";
    int left = 0;
    int count = 0;
    int min_len = (int)s.size() + 1;
    vector<int> letter_count(256, 0);
    for (char ch : t) {
        letter_count[ch] += 1;
    }
    for (int right = 0; right < s.size(); right++) {
        char right_ch = s[right];
        letter_count[right_ch] -= 1;
        if (letter_count[right_ch] >= 0) {
            count += 1;
        }
        while (count == t.size()) {
            if (right - left + 1 < min_len) {
                min_len = right - left + 1;
                result = s.substr(left, min_len);
            }
            char left_ch = s[left];
            letter_count[left_ch] += 1;
            if (letter_count[left_ch] > 0) {
                count -= 1;
            }
            left += 1;
        }
    }
    return result;
}

int main() {
    string s = "ADOBECODEBANC";
    string t = "ABC";
    cout << MinWindow(s, t);
    return 0;
}