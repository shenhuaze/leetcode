#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

vector<int> GrayCode(int n) {
    vector<int> result;
    for (int i = 0; i < pow(2, n); i++) {
        result.push_back((i >> 1) ^ i);
    }
    return result;
}

int main() {
    vector<int> result = GrayCode(2);
    for (int i: result) {
        cout << i << " ";
    }
    return 0;
}