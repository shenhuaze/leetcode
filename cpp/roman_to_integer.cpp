#include <iostream>
#include <map>

using namespace std;

int RomanToInt(string s) {
    map<char, int> roman_to_int = {{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}};
    int num = 0;
    for (int i = 0; i < s.size(); i++) {
        if (i == s.size() - 1) {
            num += roman_to_int[s[i]];
        } else if (roman_to_int[s[i]] >= roman_to_int[s[i + 1]]) {
            num += roman_to_int[s[i]];
        } else {
            num -= roman_to_int[s[i]];
        }
    }
    return num;
}

int main() {
    string s = "MCMXCIV";
    cout << RomanToInt(s);
    return 0;
}