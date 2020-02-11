#include <iostream>

using namespace std;

bool IsAlphabet(char ch) {
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
}

char Lower(char ch) {
    if (ch >= 'A' && ch <= 'Z') {
        ch += 32;
    }
    return ch;
}

bool IsPalindrome(string s) {
    int left = 0;
    int right = s.size();
    while (left < right) {
        if (!IsAlphabet(s[left])) {
            left += 1;
        } else if (!IsAlphabet(s[right])) {
            right -= 1;
        } else if (Lower(s[left]) == Lower(s[right])) {
            left += 1;
            right -= 1;
        } else {
            return false;
        }
    }
    return true;
}

int main() {
    cout << IsPalindrome("A man, a plan, a canal: Panama");
    return 0;
}