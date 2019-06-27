#include <iostream>
#include <vector>

using namespace std;

string IntToRoman(int num) {
    vector<char> roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    vector<int> value = {1000, 500, 100, 50, 10, 5, 1};
    string result = "";
    for (int i = 0; i < roman.size(); i += 2) {
        int x = num / value[i];
        if (x < 4) {
            for (int j = 1; j <= x; j++) {
                result += roman[i];
            }
        } else if (x == 4) {
            result += roman[i];
            result += roman[i - 1];
        } else if (x < 9) {
            result += roman[i - 1];
            for (int j = 6; j <= x; j++) {
                result += roman[i];
            }
        } else if (x == 9) {
            result += roman[i];
            result += roman[i - 2];
        }
        num %= value[i];
    }
    return result;
}

int main() {
    int num = 1994;
    cout << IntToRoman(num);
    return 0;
}