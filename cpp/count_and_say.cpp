#include <iostream>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-07-17
 */
string GenerateNextSequence(string s) {
    string result;
    int i = 0;
    while (i < s.size()) {
        char ch = s[i];
        int count = 0;
        for (int j = i; j < s.size(); j++) {
            if (s[j] != ch) {
                break;
            }
            count += 1;
        }
        result += to_string(count);
        result += ch;
        i += count;
    }
    return result;
}

string CountAndSay(int n) {
    if (n == 1) {
        return "1";
    } else {
        return GenerateNextSequence(CountAndSay(n - 1));
    }
}

int main() {
    cout << CountAndSay(4);
    return 0;
}