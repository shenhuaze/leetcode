#include <iostream>

using namespace std;

string Convert(string s, int num_rows) {
    if (num_rows <= 1) {
        return s;
    }
    string result;
    for (int i = 0; i < num_rows; i++) {
        for (int j = i; j < s.size(); j += 2 * num_rows - 2) {
            result += s[j];
            int temp = j + 2 * num_rows - 2 - 2 * i;
            if (i > 0 && i < num_rows - 1 && temp < s.size()) {
                result += s[temp];
            }
        }
    }
    return result;
}

int main() {
    string s = "PAYPALISHIRING";
    int num_rows = 3;
    string result = Convert(s, num_rows);
    cout << result;
    return 0;
}