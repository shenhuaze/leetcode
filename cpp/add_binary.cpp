#include <iostream>

using namespace std;

string AddBinary(string a, string b) {
    if (a.empty()) {
        return b;
    }
    if (b.empty()) {
        return a;
    }
    int i = (int)a.size() - 1;
    int j = (int)b.size() - 1;
    int carry = 0;
    string result;
    while (i >= 0 || j >= 0) {
        int sum = carry;
        if (i >= 0) {
            sum += a[i] - '0';
            i -= 1;
        }
        if (j >= 0) {
            sum += b[j] - '0';
            j -= 1;
        }
        result.insert(0, to_string(sum % 2));
        carry = sum / 2;
    }
    if (carry > 0) {
        result.insert(0, to_string(carry));
    }
    return result;
}

int main() {
    string a = "1010";
    string b = "1011";
    cout << AddBinary(a, b);
    return 0;
}