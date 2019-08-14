#include <iostream>
#include <vector>

using namespace std;

string GetPermutation(int n, int k) {
    string result;
    string num = "123456789";
    vector<int> factorial(n, 1);
    for (int i = 1; i < n; i++) {
        factorial[i] = factorial[i - 1] * i;
    }
    k -= 1;
    for (int i = 0; i < n; i++) {
        int index = k / factorial[n - i - 1];
        k %= factorial[n - i - 1];
        result += num[index];
        num.erase(index, 1);
    }
    return result;
}

int main() {
    int n = 4;
    int k = 7;
    cout << GetPermutation(n, k);
    return 0;
}