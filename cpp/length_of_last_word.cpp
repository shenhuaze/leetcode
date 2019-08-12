#include <iostream>

using namespace std;

// Solution 1
int LengthOfLastWord(string s) {
    if (s.empty()) {
        return 0;
    }
    int i = int(s.size()) - 1;
    while (i >= 0 && s[i] == ' ') {
        i -= 1;
    }
    int len = 0;
    while (i >= 0 && s[i] != ' ') {
        len += 1;
        i -= 1;
    }
    return len;
}

// Solution 2
int LengthOfLastWord2(string s) {
    if (s.empty()) {
        return 0;
    }
    int size = int(s.size());
    int left = 0;
    int right = size - 1;
    while (left <= size and s[left] == ' ') {
        left += 1;
    }
    while (right >= 0 and s[right] == ' ') {
        right -= 1;
    }
    int len = 0;
    for (int i = left; i <= right; i++) {
        if (s[i] == ' ') {
            len = 0;
        } else {
            len += 1;
        }
    }
    return len;
}

int main() {
    string s = "Hello World";
    cout << LengthOfLastWord(s);
    cout << LengthOfLastWord2(s);
    return 0;
}