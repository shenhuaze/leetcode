#include <iostream>

using namespace std;

int MyAtoi(string str) {
    if (str.empty()) {
        return 0;
    }
    int sign = 1;
    int base = 0;
    int i = 0;
    int n = str.size();
    while (i < n && str[i] == ' ') {
        i += 1;
    }
    if (i < n && (str[i] == '-' || str[i] == '+')) {
        if (str[i] == '-') {
            sign = -1;
        }
        i += 1;
    }
    while (i < n && str[i] >= '0' && str[i] <= '9') {
        if (base > INT_MAX / 10 || (base == INT_MAX / 10 && str[i] - '0' > 7)) {
            if (sign == 1) {
                return INT_MAX;
            } else {
                return INT_MIN;
            }
        }
        base = str[i] - '0' + base * 10;
        i += 1;
    }
    return sign * base;
}

int main() {
    //string str = "   -42";
    string str = "2147483646";
    cout << MyAtoi(str);
    return 0;
}