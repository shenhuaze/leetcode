#include <iostream>

using namespace std;

int StrStr(string haystack, string needle) {
    if (needle.empty()) {
        return 0;
    }
    if (haystack.size() < needle.size()) {
        return -1;
    }
    for (int i = 0; i < haystack.size(); i++) {
        if (needle[0] != haystack[i]) {
            continue;
        }
        int j = 0;
        while (j < needle.size()) {
            if (i + j >= haystack.size()) {
                break;
            }
            if (needle[j] != haystack[i + j]) {
                break;
            }
            j += 1;
        }
        if (j == needle.size()) {
            return i;
        }
    }
    return -1;
}

int main() {
    string haystack = "hello";
    string needle = "ll";
    cout << StrStr(haystack, needle);
    return 0;
}