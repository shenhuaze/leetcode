#include <iostream>
#include <regex>

using namespace std;

bool IsNumber(string s) {
    if (s.empty()) {
        return false;
    }
    return regex_match(s, regex("[-+]?(?:[0-9]+\\.?|\\.[0-9]+)[0-9]*(?:e[-+]?[0-9]+)?"));
}

int main() {
    //string s = "53.5e93";
    string s = "1";
    //string s = "e9";
    cout << IsNumber(s);
    return 0;
}