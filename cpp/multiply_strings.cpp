#include <iostream>
#include <vector>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-07-20
 */
string Multiply(string num1, string num2) {
    int m = num1.size();
    int n = num2.size();
    vector<int> pos(m + n);
    for (int i = m - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {
            int mul = (num1[i] - '0') * (num2[j] - '0');
            int p1 = i + j;
            int p2 = i + j + 1;
            int sum = mul + pos[p2];
            pos[p1] += sum / 10;
            pos[p2] = sum % 10;
        }
    }
    string result;
    for (int i : pos) {
        if (i == 0 && result.empty()) {
            continue;
        }
        result += to_string(i);
    }
    return result.empty() ? "0" : result;
}

int main() {
    string num1 = "123";
    string num2 = "456";
    cout << Multiply(num1, num2);
    return 0;
}