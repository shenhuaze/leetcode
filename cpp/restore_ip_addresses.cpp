#include <iostream>
#include <vector>

using namespace std;

bool IsValid(string s) {
    if (s.size() > 1 && s[0] == '0') {
        return false;
    }
    //int i = strtol(s.c_str());
    int i = atoi(s.c_str());
    return i >= 0 && i < 256;
}

void Restore(vector<string>& results, string remain, string result, int k) {
    if (k == 0) {
        if (remain.empty()) {
            results.push_back(result);
        }
    } else {
        for (int i = 1; i <= 3; i++) {
            if (remain.size() >= i && IsValid(remain.substr(0, i))) {
                if (k == 1) {
                    Restore(results, remain.substr(i), result + remain.substr(0, i), k - 1);
                } else {
                    Restore(results, remain.substr(i), result + remain.substr(0, i) + ".", k - 1);
                }
            }
        }
    }
}

vector<string> RestoreIpAddresses(string s) {
    vector<string> results;
    Restore(results, s, "", 4);
    return results;
}

int main() {
    string s = "25525511135";
    vector<string> results = RestoreIpAddresses(s);
    for (string result: results) {
        cout << result << "\n";
    }
    return 0;
}