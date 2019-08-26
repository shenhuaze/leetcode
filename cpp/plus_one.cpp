#include <iostream>
#include <vector>

using namespace std;

vector<int> PlusOne(vector<int>& digits) {
    if (digits.empty()) {
        return digits;
    }
    int size = (int)digits.size();
    for (int i = size - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i] += 1;
            return digits;
        }
        digits[i] = 0;
    }
    digits.insert(digits.begin(), 1);
    return digits;
}

int main() {
    //vector<int> digits = {1, 2, 3};
    vector<int> digits = {9, 9, 9};
    vector<int> results = PlusOne(digits);
    for (int i : results) {
        cout << i << ", ";
    }
    return 0;
}