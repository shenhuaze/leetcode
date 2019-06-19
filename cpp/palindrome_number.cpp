#include <iostream>

using namespace std;

bool IsPalindrome(int x) {
    if (x < 0) {
        return false;
    }
    int divided_number = 1;
    while (x / divided_number >= 10) {
        divided_number *= 10;
    }
    while (x > 0) {
        int left = x / divided_number;
        int right = x % 10;
        if (left != right) {
            return false;
        }
        x = (x % divided_number) / 10;
        divided_number /= 100;
    }
    return true;
}

int main() {
    int x = 1001;
    cout << IsPalindrome(x);
    return 0;
}